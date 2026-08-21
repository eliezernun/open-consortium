package org.consortiumcore.productcatalog.application.service;

import org.consortiumcore.productcatalog.application.command.PublishProductVersionCommand;
import org.consortiumcore.productcatalog.application.exception.ProductNotFoundException;
import org.consortiumcore.productcatalog.application.exception.ProductVersionNotFoundException;
import org.consortiumcore.productcatalog.application.exception.ProductVersionPeriodConflictException;
import org.consortiumcore.productcatalog.application.port.in.PublishProductVersionUseCase;
import org.consortiumcore.productcatalog.application.port.out.ConfigurationHashGenerator;
import org.consortiumcore.productcatalog.application.port.out.DomainEventPublisher;
import org.consortiumcore.productcatalog.application.port.out.ProductRepository;
import org.consortiumcore.productcatalog.application.port.out.ProductTypeProvider;
import org.consortiumcore.productcatalog.application.port.out.ProductVersionRepository;
import org.consortiumcore.productcatalog.application.result.ProductVersionResult;
import org.consortiumcore.productcatalog.domain.product.Product;
import org.consortiumcore.productcatalog.domain.service.ProductVersionValidator;
import org.consortiumcore.productcatalog.domain.version.ConfigurationHash;
import org.consortiumcore.productcatalog.domain.version.ProductVersion;
import org.consortiumcore.productcatalog.domain.version.ProductVersionStatus;

public final class PublishProductVersionService implements PublishProductVersionUseCase {

    private final ProductRepository productRepository;
    private final ProductVersionRepository productVersionRepository;
    private final ProductTypeProvider productTypeProvider;
    private final ConfigurationHashGenerator configurationHashGenerator;
    private final DomainEventPublisher eventPublisher;
    private final ProductVersionValidator validator;

    public PublishProductVersionService(
            ProductRepository productRepository,
            ProductVersionRepository productVersionRepository,
            ProductTypeProvider productTypeProvider,
            ConfigurationHashGenerator configurationHashGenerator,
            DomainEventPublisher eventPublisher,
            ProductVersionValidator validator
    ) {
        this.productRepository = productRepository;
        this.productVersionRepository = productVersionRepository;
        this.productTypeProvider = productTypeProvider;
        this.configurationHashGenerator = configurationHashGenerator;
        this.eventPublisher = eventPublisher;
        this.validator = validator;
    }

    @Override
    public ProductVersionResult publish(PublishProductVersionCommand command) {
        ProductVersion productVersion = productVersionRepository.findById(command.productVersionId())
                .orElseThrow(() -> new ProductVersionNotFoundException(command.productVersionId()));
        Product product = productRepository.findById(productVersion.productId())
                .orElseThrow(() -> new ProductNotFoundException(productVersion.productId()));

        productVersionRepository.findPublishedByProductId(product.id()).stream()
                .filter(published -> published.effectivePeriod().overlaps(command.effectivePeriod()))
                .findFirst()
                .ifPresent(conflict -> {
                    throw new ProductVersionPeriodConflictException(conflict.id());
                });

        if (productVersion.status() == ProductVersionStatus.DRAFT) {
            productVersion.submitForReview();
        }

        ConfigurationHash configurationHash = configurationHashGenerator.generate(
                productVersion.definition(),
                productVersion.regulationProfile()
        );
        productVersion.publish(
                command.effectivePeriod(),
                configurationHash,
                productTypeProvider.get(product.type()),
                validator
        );
        productVersionRepository.save(productVersion);
        eventPublisher.publish(productVersion.pullDomainEvents());
        return ProductVersionResult.from(productVersion);
    }
}
