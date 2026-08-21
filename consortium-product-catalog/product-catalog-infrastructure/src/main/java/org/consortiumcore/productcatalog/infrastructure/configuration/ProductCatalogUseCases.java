package org.consortiumcore.productcatalog.infrastructure.configuration;

import org.consortiumcore.productcatalog.application.port.in.ActivateProductUseCase;
import org.consortiumcore.productcatalog.application.port.in.CreateProductUseCase;
import org.consortiumcore.productcatalog.application.port.in.CreateProductVersionUseCase;
import org.consortiumcore.productcatalog.application.port.in.ObtainPublishedProductVersionUseCase;
import org.consortiumcore.productcatalog.application.port.in.PublishProductVersionUseCase;

public record ProductCatalogUseCases(
        CreateProductUseCase createProduct,
        ActivateProductUseCase activateProduct,
        CreateProductVersionUseCase createProductVersion,
        PublishProductVersionUseCase publishProductVersion,
        ObtainPublishedProductVersionUseCase obtainPublishedProductVersion
) {
}
