package org.consortiumcore.productcatalog.domain;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Currency;
import java.util.Set;
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
import org.consortiumcore.productcatalog.domain.exception.InvalidEffectivePeriodException;
import org.consortiumcore.productcatalog.domain.exception.InvalidProductCodeException;
import org.consortiumcore.productcatalog.domain.exception.InvalidProductStatusTransitionException;
import org.consortiumcore.productcatalog.domain.exception.ProductCatalogValidationException;
import org.consortiumcore.productcatalog.domain.exception.PublishedProductVersionCannotBeModifiedException;
import org.consortiumcore.productcatalog.domain.product.Product;
import org.consortiumcore.productcatalog.domain.product.ProductCode;
import org.consortiumcore.productcatalog.domain.product.ProductId;
import org.consortiumcore.productcatalog.domain.product.ProductName;
import org.consortiumcore.productcatalog.domain.product.ProductStatus;
import org.consortiumcore.productcatalog.domain.product.ProductTypeCode;
import org.consortiumcore.productcatalog.domain.regulation.RegulationProfile;
import org.consortiumcore.productcatalog.domain.regulation.RegulationSetId;
import org.consortiumcore.productcatalog.domain.regulation.RuleReference;
import org.consortiumcore.productcatalog.domain.service.ProductVersionValidator;
import org.consortiumcore.productcatalog.domain.type.AdjustmentType;
import org.consortiumcore.productcatalog.domain.type.MovableGoodsProductType;
import org.consortiumcore.productcatalog.domain.version.ConfigurationHash;
import org.consortiumcore.productcatalog.domain.version.EffectivePeriod;
import org.consortiumcore.productcatalog.domain.version.ProductVersion;
import org.consortiumcore.productcatalog.domain.version.ProductVersionId;
import org.consortiumcore.productcatalog.domain.version.ProductVersionStatus;
import org.consortiumcore.productcatalog.domain.version.VersionNumber;
import org.junit.jupiter.api.Test;

class ProductCatalogDomainTest {

    @Test
    void normalizesProductCode() {
        ProductCode code = new ProductCode(" abc_123 ");

        assertEquals("ABC_123", code.value());
    }

    @Test
    void rejectsInvalidProductCode() {
        assertThrows(InvalidProductCodeException.class, () -> new ProductCode("ab"));
    }

    @Test
    void enforcesProductStatusTransitions() {
        Product product = Product.create(
                ProductId.generate(),
                new ProductCode("CAR_001"),
                new ProductName("Vehicle Plan"),
                ProductTypeCode.MOVABLE_GOODS
        );

        product.activate();
        assertEquals(ProductStatus.ACTIVE, product.status());

        product.suspend();
        assertEquals(ProductStatus.SUSPENDED, product.status());

        product.activate();
        product.retire();
        assertEquals(ProductStatus.RETIRED, product.status());

        assertThrows(InvalidProductStatusTransitionException.class, product::activate);
    }

    @Test
    void validatesVersionNumberAndEffectivePeriod() {
        assertThrows(ProductCatalogValidationException.class, () -> new VersionNumber(0));
        assertThrows(
                InvalidEffectivePeriodException.class,
                () -> new EffectivePeriod(LocalDate.parse("2026-02-01"), LocalDate.parse("2026-01-31"))
        );

        EffectivePeriod period = new EffectivePeriod(LocalDate.parse("2026-01-01"), LocalDate.parse("2026-12-31"));
        assertDoesNotThrow(() -> period.includes(LocalDate.parse("2026-08-20")));
    }

    @Test
    void validatesDefinitionRanges() {
        assertThrows(ProductCatalogValidationException.class, () -> new Money(new BigDecimal("-1"), Currency.getInstance("BRL")));
        assertThrows(RuntimeException.class, () -> new MonthRange(12, 6));
        assertThrows(RuntimeException.class, () -> new QuotaCapacityRange(0, 10));
    }

    @Test
    void publishesOnlyReviewedVersionAndLocksDefinition() {
        ProductVersion version = ProductVersion.create(
                ProductVersionId.generate(),
                ProductId.generate(),
                new VersionNumber(1),
                definition(),
                regulationProfile()
        );

        assertThrows(
                PublishedProductVersionCannotBeModifiedException.class,
                () -> version.publish(
                        new EffectivePeriod(LocalDate.parse("2026-01-01"), null),
                        new ConfigurationHash("hash"),
                        new MovableGoodsProductType(),
                        new ProductVersionValidator()
                )
        );

        version.submitForReview();
        version.publish(
                new EffectivePeriod(LocalDate.parse("2026-01-01"), null),
                new ConfigurationHash("hash"),
                new MovableGoodsProductType(),
                new ProductVersionValidator()
        );

        assertEquals(ProductVersionStatus.PUBLISHED, version.status());
        assertThrows(PublishedProductVersionCannotBeModifiedException.class, () -> version.changeDefinition(definition()));

        version.suspend();
        assertEquals(ProductVersionStatus.SUSPENDED, version.status());

        version.reactivate();
        assertEquals(ProductVersionStatus.PUBLISHED, version.status());
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

    private static RegulationProfile regulationProfile() {
        return new RegulationProfile(
                new RegulationSetId("BACEN-2026"),
                LocalDate.parse("2026-08-20"),
                Set.of(new RuleReference("rule.minimum-definition", "1", "Circular")),
                Set.of()
        );
    }
}
