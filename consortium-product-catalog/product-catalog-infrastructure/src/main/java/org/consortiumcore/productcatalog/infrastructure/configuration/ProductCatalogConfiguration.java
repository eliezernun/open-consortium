package org.consortiumcore.productcatalog.infrastructure.configuration;

import org.consortiumcore.productcatalog.api.ProductCatalog;
import org.consortiumcore.productcatalog.application.port.out.ConfigurationHashGenerator;
import org.consortiumcore.productcatalog.application.port.out.DomainEventPublisher;
import org.consortiumcore.productcatalog.application.port.out.ProductRepository;
import org.consortiumcore.productcatalog.application.port.out.ProductTypeProvider;
import org.consortiumcore.productcatalog.application.port.out.ProductVersionRepository;
import org.consortiumcore.productcatalog.application.port.out.RegulationProfileProvider;
import org.consortiumcore.productcatalog.application.service.ActivateProductService;
import org.consortiumcore.productcatalog.application.service.CreateProductService;
import org.consortiumcore.productcatalog.application.service.CreateProductVersionService;
import org.consortiumcore.productcatalog.application.service.ObtainPublishedProductVersionService;
import org.consortiumcore.productcatalog.application.service.PublishProductVersionService;
import org.consortiumcore.productcatalog.domain.service.ProductVersionValidator;
import org.consortiumcore.productcatalog.infrastructure.catalog.ProductCatalogAdapter;
import org.consortiumcore.productcatalog.infrastructure.event.NoOpDomainEventPublisher;
import org.consortiumcore.productcatalog.infrastructure.hash.StableConfigurationHashGenerator;
import org.consortiumcore.productcatalog.infrastructure.persistence.adapter.InMemoryProductRepository;
import org.consortiumcore.productcatalog.infrastructure.persistence.adapter.InMemoryProductVersionRepository;
import org.consortiumcore.productcatalog.infrastructure.regulation.FixedRegulationProfileProvider;
import org.consortiumcore.productcatalog.infrastructure.type.RegistryProductTypeProvider;

public final class ProductCatalogConfiguration {

    private ProductCatalogConfiguration() {
    }

    public static ProductCatalog inMemoryCatalog() {
        return catalog(
                new InMemoryProductRepository(),
                new InMemoryProductVersionRepository(),
                new RegistryProductTypeProvider(),
                new FixedRegulationProfileProvider(),
                new StableConfigurationHashGenerator(),
                new NoOpDomainEventPublisher()
        );
    }

    public static ProductCatalog catalog(
            ProductRepository productRepository,
            ProductVersionRepository productVersionRepository,
            ProductTypeProvider productTypeProvider,
            RegulationProfileProvider regulationProfileProvider,
            ConfigurationHashGenerator configurationHashGenerator,
            DomainEventPublisher eventPublisher
    ) {
        ProductVersionValidator validator = new ProductVersionValidator();
        return new ProductCatalogAdapter(
                new ObtainPublishedProductVersionService(productRepository, productVersionRepository)
        );
    }

    public static ProductCatalogUseCases useCases(
            ProductRepository productRepository,
            ProductVersionRepository productVersionRepository,
            ProductTypeProvider productTypeProvider,
            RegulationProfileProvider regulationProfileProvider,
            ConfigurationHashGenerator configurationHashGenerator,
            DomainEventPublisher eventPublisher
    ) {
        ProductVersionValidator validator = new ProductVersionValidator();
        return new ProductCatalogUseCases(
                new CreateProductService(productRepository, eventPublisher),
                new ActivateProductService(productRepository, eventPublisher),
                new CreateProductVersionService(
                        productRepository,
                        productVersionRepository,
                        regulationProfileProvider,
                        eventPublisher
                ),
                new PublishProductVersionService(
                        productRepository,
                        productVersionRepository,
                        productTypeProvider,
                        configurationHashGenerator,
                        eventPublisher,
                        validator
                ),
                new ObtainPublishedProductVersionService(productRepository, productVersionRepository)
        );
    }
}
