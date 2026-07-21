package org.consortiumcore.productcatalog.application.service;

import java.time.LocalDate;
import org.consortiumcore.productcatalog.application.exception.ProductNotFoundException;
import org.consortiumcore.productcatalog.application.port.in.ObtainPublishedProductVersionUseCase;
import org.consortiumcore.productcatalog.application.port.out.ProductRepository;
import org.consortiumcore.productcatalog.application.port.out.ProductVersionRepository;
import org.consortiumcore.productcatalog.domain.error.ProductCatalogError;
import org.consortiumcore.productcatalog.domain.exception.ProductCatalogValidationException;
import org.consortiumcore.productcatalog.domain.product.Product;
import org.consortiumcore.productcatalog.domain.product.ProductId;
import org.consortiumcore.productcatalog.domain.version.ProductConfigurationSnapshot;
import org.consortiumcore.productcatalog.domain.version.ProductVersion;
import org.consortiumcore.productcatalog.domain.version.PublishedProductVersion;

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
    public PublishedProductVersion obtain(ProductId productId, LocalDate referenceDate) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new ProductNotFoundException(productId));
        ProductVersion version = productVersionRepository.findEffectivePublishedVersion(productId, referenceDate)
                .orElseThrow(() -> new ProductCatalogValidationException(
                        ProductCatalogError.EFFECTIVE_PUBLISHED_VERSION_NOT_FOUND
                ));
        return new PublishedProductVersion(
                product.id(),
                version.id(),
                product.code(),
                product.type(),
                version.versionNumber(),
                version.effectivePeriod(),
                new ProductConfigurationSnapshot(version.definition(), version.regulationProfile()),
                version.configurationHash()
        );
    }
}
