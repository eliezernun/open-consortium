package org.consortiumcore.productcatalog.application.service;

import java.time.LocalDate;
import org.consortiumcore.productcatalog.api.ProductConfigurationSnapshot;
import org.consortiumcore.productcatalog.api.ProductVersionReference;
import org.consortiumcore.productcatalog.api.PublishedProductVersion;
import org.consortiumcore.productcatalog.application.exception.ProductNotFoundException;
import org.consortiumcore.productcatalog.application.port.in.ObtainPublishedProductVersionUseCase;
import org.consortiumcore.productcatalog.application.port.out.ProductRepository;
import org.consortiumcore.productcatalog.application.port.out.ProductVersionRepository;
import org.consortiumcore.productcatalog.domain.definition.ProductDefinition;
import org.consortiumcore.productcatalog.domain.error.ProductCatalogError;
import org.consortiumcore.productcatalog.domain.exception.ProductCatalogValidationException;
import org.consortiumcore.productcatalog.domain.product.Product;
import org.consortiumcore.productcatalog.domain.product.ProductId;
import org.consortiumcore.productcatalog.domain.version.ProductVersion;
import org.consortiumcore.productcatalog.domain.version.ProductVersionId;

public final class ObtainPublishedProductVersionService implements ObtainPublishedProductVersionUseCase {

    private final ProductRepository productRepository;
    private final ProductVersionRepository productVersionRepository;

    public ObtainPublishedProductVersionService(
            ProductRepository productRepository,
            ProductVersionRepository productVersionRepository
    ) {
        this.productRepository = productRepository;
        this.productVersionRepository = productVersionRepository;
    }

    @Override
    public PublishedProductVersion obtain(ProductVersionReference reference, LocalDate referenceDate) {
        ProductId productId = new ProductId(reference.productId());
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new ProductNotFoundException(productId));
        ProductVersion version = productVersionRepository.findEffectivePublishedVersion(productId, referenceDate)
                .orElseThrow(() -> new ProductCatalogValidationException(
                        ProductCatalogError.EFFECTIVE_PUBLISHED_VERSION_NOT_FOUND
                ));
        ProductVersionId expectedVersionId = new ProductVersionId(reference.productVersionId());
        if (!version.id().equals(expectedVersionId)) {
            throw new ProductCatalogValidationException(
                    ProductCatalogError.EFFECTIVE_PUBLISHED_VERSION_NOT_FOUND
            );
        }
        return new PublishedProductVersion(
                product.id().value(),
                version.id().value(),
                product.code().value(),
                product.type().value(),
                version.versionNumber().value(),
                version.effectivePeriod().from(),
                version.effectivePeriod().until(),
                snapshotOf(version.definition()),
                version.configurationHash().value()
        );
    }

    private static ProductConfigurationSnapshot snapshotOf(ProductDefinition definition) {
        return new ProductConfigurationSnapshot(
                new ProductConfigurationSnapshot.GroupConfiguration(
                        definition.group().quotaCapacity().minimum(),
                        definition.group().quotaCapacity().maximum(),
                        definition.group().requiresEconomicViabilityAssessment()
                ),
                new ProductConfigurationSnapshot.CreditConfiguration(
                        definition.credit().allowedRange().minimum().amount(),
                        definition.credit().allowedRange().maximum().amount(),
                        definition.credit().currency(),
                        definition.credit().allowsMultipleCreditPlans()
                ),
                new ProductConfigurationSnapshot.DurationConfiguration(
                        definition.duration().allowedDuration().minimum(),
                        definition.duration().allowedDuration().maximum()
                ),
                new ProductConfigurationSnapshot.PercentageRangeConfiguration(
                        definition.administrationFee().allowedRate().minimum().value(),
                        definition.administrationFee().allowedRate().maximum().value()
                ),
                new ProductConfigurationSnapshot.ReserveFundConfiguration(
                        definition.reserveFund().enabled(),
                        definition.reserveFund().allowedRate().minimum().value(),
                        definition.reserveFund().allowedRate().maximum().value()
                ),
                new ProductConfigurationSnapshot.AdjustmentConfiguration(
                        definition.adjustment().type().name(),
                        definition.adjustment().referenceIndex().value()
                ),
                new ProductConfigurationSnapshot.AssemblyConfiguration(
                        definition.assembly().allowsElectronicAssembly()
                )
        );
    }
}
