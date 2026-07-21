package org.consortiumcore.productcatalog.infrastructure.catalog;

import java.time.LocalDate;
import org.consortiumcore.productcatalog.api.ProductCatalog;
import org.consortiumcore.productcatalog.application.command.ActivateProductCommand;
import org.consortiumcore.productcatalog.application.command.CreateProductCommand;
import org.consortiumcore.productcatalog.application.command.CreateProductVersionCommand;
import org.consortiumcore.productcatalog.application.command.PublishProductVersionCommand;
import org.consortiumcore.productcatalog.application.command.UpdateProductVersionCommand;
import org.consortiumcore.productcatalog.application.port.in.ActivateProductUseCase;
import org.consortiumcore.productcatalog.application.port.in.CreateProductUseCase;
import org.consortiumcore.productcatalog.application.port.in.CreateProductVersionUseCase;
import org.consortiumcore.productcatalog.application.port.in.ObtainPublishedProductVersionUseCase;
import org.consortiumcore.productcatalog.application.port.in.PublishProductVersionUseCase;
import org.consortiumcore.productcatalog.application.port.in.UpdateProductVersionUseCase;
import org.consortiumcore.productcatalog.application.result.ProductResult;
import org.consortiumcore.productcatalog.application.result.ProductVersionResult;
import org.consortiumcore.productcatalog.domain.product.ProductId;
import org.consortiumcore.productcatalog.domain.version.PublishedProductVersion;

public final class ProductCatalogAdapter implements ProductCatalog {

    private final CreateProductUseCase createProductUseCase;
    private final ActivateProductUseCase activateProductUseCase;
    private final CreateProductVersionUseCase createProductVersionUseCase;
    private final UpdateProductVersionUseCase updateProductVersionUseCase;
    private final PublishProductVersionUseCase publishProductVersionUseCase;
    private final ObtainPublishedProductVersionUseCase obtainPublishedProductVersionUseCase;

    public ProductCatalogAdapter(
            CreateProductUseCase createProductUseCase,
            ActivateProductUseCase activateProductUseCase,
            CreateProductVersionUseCase createProductVersionUseCase,
            UpdateProductVersionUseCase updateProductVersionUseCase,
            PublishProductVersionUseCase publishProductVersionUseCase,
            ObtainPublishedProductVersionUseCase obtainPublishedProductVersionUseCase
    ) {
        this.createProductUseCase = createProductUseCase;
        this.activateProductUseCase = activateProductUseCase;
        this.createProductVersionUseCase = createProductVersionUseCase;
        this.updateProductVersionUseCase = updateProductVersionUseCase;
        this.publishProductVersionUseCase = publishProductVersionUseCase;
        this.obtainPublishedProductVersionUseCase = obtainPublishedProductVersionUseCase;
    }

    @Override
    public ProductResult createProduct(CreateProductCommand command) {
        return createProductUseCase.create(command);
    }

    @Override
    public ProductResult activateProduct(ActivateProductCommand command) {
        return activateProductUseCase.activate(command);
    }

    @Override
    public ProductVersionResult createProductVersion(CreateProductVersionCommand command) {
        return createProductVersionUseCase.createVersion(command);
    }

    @Override
    public ProductVersionResult updateProductVersion(UpdateProductVersionCommand command) {
        return updateProductVersionUseCase.updateVersion(command);
    }

    @Override
    public ProductVersionResult publishProductVersion(PublishProductVersionCommand command) {
        return publishProductVersionUseCase.publish(command);
    }

    @Override
    public PublishedProductVersion obtainPublishedProductVersion(ProductId productId, LocalDate referenceDate) {
        return obtainPublishedProductVersionUseCase.obtain(productId, referenceDate);
    }
}
