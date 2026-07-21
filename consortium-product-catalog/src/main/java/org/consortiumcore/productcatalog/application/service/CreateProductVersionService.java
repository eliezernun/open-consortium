package org.consortiumcore.productcatalog.application.service;

import java.util.Comparator;
import java.util.List;
import org.consortiumcore.productcatalog.application.command.CreateProductVersionCommand;
import org.consortiumcore.productcatalog.application.exception.ProductNotFoundException;
import org.consortiumcore.productcatalog.application.port.in.CreateProductVersionUseCase;
import org.consortiumcore.productcatalog.application.port.out.DomainEventPublisher;
import org.consortiumcore.productcatalog.application.port.out.ProductRepository;
import org.consortiumcore.productcatalog.application.port.out.ProductVersionRepository;
import org.consortiumcore.productcatalog.application.port.out.RegulationProfileProvider;
import org.consortiumcore.productcatalog.application.result.ProductVersionResult;
import org.consortiumcore.productcatalog.domain.error.ProductCatalogError;
import org.consortiumcore.productcatalog.domain.event.ProductVersionCreated;
import org.consortiumcore.productcatalog.domain.exception.ProductCatalogValidationException;
import org.consortiumcore.productcatalog.domain.product.Product;
import org.consortiumcore.productcatalog.domain.regulation.RegulationProfile;
import org.consortiumcore.productcatalog.domain.version.ProductVersion;
import org.consortiumcore.productcatalog.domain.version.ProductVersionId;
import org.consortiumcore.productcatalog.domain.version.VersionNumber;

public final class CreateProductVersionService implements CreateProductVersionUseCase {

    private final ProductRepository productRepository;
    private final ProductVersionRepository productVersionRepository;
    private final RegulationProfileProvider regulationProfileProvider;
    private final DomainEventPublisher eventPublisher;

    public CreateProductVersionService(
            ProductRepository productRepository,
            ProductVersionRepository productVersionRepository,
            RegulationProfileProvider regulationProfileProvider,
            DomainEventPublisher eventPublisher
    ) {
        this.productRepository = productRepository;
        this.productVersionRepository = productVersionRepository;
        this.regulationProfileProvider = regulationProfileProvider;
        this.eventPublisher = eventPublisher;
    }

    @Override
    public ProductVersionResult createVersion(CreateProductVersionCommand command) {
        Product product = productRepository.findById(command.productId())
                .orElseThrow(() -> new ProductNotFoundException(command.productId()));
        if (!product.canReceiveNewVersion()) {
            throw new ProductCatalogValidationException(ProductCatalogError.RETIRED_PRODUCT_CANNOT_RECEIVE_VERSION);
        }

        VersionNumber nextVersion = productVersionRepository.findByProductId(product.id()).stream()
                .map(ProductVersion::versionNumber)
                .max(Comparator.comparingInt(VersionNumber::value))
                .map(VersionNumber::next)
                .orElse(new VersionNumber(1));
        RegulationProfile regulationProfile = regulationProfileProvider.currentFor(product.type(), command.regulationReferenceDate());

        ProductVersion productVersion = ProductVersion.create(
                ProductVersionId.generate(),
                product.id(),
                nextVersion,
                command.definition(),
                regulationProfile
        );
        productVersionRepository.save(productVersion);
        eventPublisher.publish(List.of(new ProductVersionCreated(productVersion.id(), product.id(), nextVersion)));
        return ProductVersionResult.from(productVersion);
    }
}
