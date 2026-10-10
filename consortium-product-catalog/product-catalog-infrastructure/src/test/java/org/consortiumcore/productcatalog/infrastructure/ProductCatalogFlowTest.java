package org.consortiumcore.productcatalog.infrastructure;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Currency;
import org.consortiumcore.productcatalog.api.ProductVersionReference;
import org.consortiumcore.productcatalog.api.PublishedProductVersion;
import org.consortiumcore.productcatalog.application.command.ActivateProductCommand;
import org.consortiumcore.productcatalog.application.command.CreateProductCommand;
import org.consortiumcore.productcatalog.application.command.CreateProductVersionCommand;
import org.consortiumcore.productcatalog.application.command.PublishProductVersionCommand;
import org.consortiumcore.productcatalog.application.result.ProductResult;
import org.consortiumcore.productcatalog.application.result.ProductVersionResult;
import org.consortiumcore.productcatalog.domain.definition.AdjustmentDefinition;
import org.consortiumcore.productcatalog.domain.definition.AdministrationFeeDefinition;
import org.consortiumcore.productcatalog.domain.definition.AssemblyDefinition;
import org.consortiumcore.productcatalog.domain.definition.CreditDefinition;
import org.consortiumcore.productcatalog.domain.definition.DurationDefinition;
import org.consortiumcore.productcatalog.domain.definition.GroupDefinition;
import org.consortiumcore.productcatalog.domain.definition.MonetaryRange;
import org.consortiumcore.productcatalog.domain.definition.Money;
import org.consortiumcore.productcatalog.domain.definition.MonthRange;
import org.consortiumcore.productcatalog.domain.definition.Percentage;
import org.consortiumcore.productcatalog.domain.definition.PercentageRange;
import org.consortiumcore.productcatalog.domain.definition.ProductDefinition;
import org.consortiumcore.productcatalog.domain.definition.QuotaCapacityRange;
import org.consortiumcore.productcatalog.domain.definition.ReferenceIndexCode;
import org.consortiumcore.productcatalog.domain.definition.ReserveFundDefinition;
import org.consortiumcore.productcatalog.domain.product.ProductCode;
import org.consortiumcore.productcatalog.domain.product.ProductName;
import org.consortiumcore.productcatalog.domain.product.ProductStatus;
import org.consortiumcore.productcatalog.domain.product.ProductTypeCode;
import org.consortiumcore.productcatalog.domain.type.AdjustmentType;
import org.consortiumcore.productcatalog.domain.version.EffectivePeriod;
import org.consortiumcore.productcatalog.domain.version.ProductVersionStatus;
import org.consortiumcore.productcatalog.infrastructure.configuration.ProductCatalogRuntime;
import org.consortiumcore.productcatalog.infrastructure.configuration.ProductCatalogConfiguration;
import org.junit.jupiter.api.Test;

class ProductCatalogFlowTest {

    @Test
    void createsPublishesAndObtainsPublishedProductVersion() {
        ProductCatalogRuntime runtime = ProductCatalogConfiguration.inMemoryRuntime();

        ProductResult product = runtime.useCases().createProduct().create(
                new CreateProductCommand(
                        new ProductCode("CAR_GROUP"),
                        new ProductName("Vehicle Consortium"),
                        ProductTypeCode.MOVABLE_GOODS
                )
        );
        ProductResult activated = runtime.useCases().activateProduct().activate(new ActivateProductCommand(product.id()));
        ProductVersionResult draftVersion = runtime.useCases().createProductVersion().createVersion(
                new CreateProductVersionCommand(
                        product.id(),
                        definition(),
                        LocalDate.parse("2026-08-20")
                )
        );

        ProductVersionResult published = runtime.useCases().publishProductVersion().publish(
                new PublishProductVersionCommand(
                        draftVersion.id(),
                        new EffectivePeriod(LocalDate.parse("2026-09-01"), null)
                )
        );
        PublishedProductVersion obtained = runtime.catalog().obtainPublishedVersion(
                new ProductVersionReference(product.id().value(), published.id().value()),
                LocalDate.parse("2026-09-15")
        );

        assertEquals(ProductStatus.ACTIVE, activated.status());
        assertEquals(ProductVersionStatus.PUBLISHED, published.status());
        assertEquals(product.id().value(), obtained.productId());
        assertEquals(published.id().value(), obtained.productVersionId());
        assertEquals("CAR_GROUP", obtained.productCode());
        assertEquals("MOVABLE_GOODS", obtained.productType());
        assertEquals(published.configurationHash().value(), obtained.configurationHash());
        assertNotNull(obtained.configuration());
    }

    private static ProductDefinition definition() {
        Currency brl = Currency.getInstance("BRL");
        return new ProductDefinition(
                new GroupDefinition(new QuotaCapacityRange(10, 120), true),
                new CreditDefinition(
                        new MonetaryRange(
                                new Money(new BigDecimal("10000"), brl),
                                new Money(new BigDecimal("80000"), brl)
                        ),
                        brl,
                        true
                ),
                new DurationDefinition(new MonthRange(12, 80)),
                new AdministrationFeeDefinition(rate("10", "20")),
                new ReserveFundDefinition(true, rate("1", "5")),
                new AdjustmentDefinition(AdjustmentType.PRICE_INDEX, ReferenceIndexCode.IPCA),
                new AssemblyDefinition(true)
        );
    }

    private static PercentageRange rate(String minimum, String maximum) {
        return new PercentageRange(
                Percentage.ofPercent(minimum),
                Percentage.ofPercent(maximum)
        );
    }
}
