package org.consortiumcore.productcatalog.api;

import java.time.LocalDate;
import org.consortiumcore.productcatalog.application.command.ActivateProductCommand;
import org.consortiumcore.productcatalog.application.command.CreateProductCommand;
import org.consortiumcore.productcatalog.application.command.CreateProductVersionCommand;
import org.consortiumcore.productcatalog.application.command.PublishProductVersionCommand;
import org.consortiumcore.productcatalog.application.command.UpdateProductVersionCommand;
import org.consortiumcore.productcatalog.application.result.ProductResult;
import org.consortiumcore.productcatalog.application.result.ProductVersionResult;
import org.consortiumcore.productcatalog.domain.product.ProductId;
import org.consortiumcore.productcatalog.domain.version.PublishedProductVersion;

public interface ProductCatalog {

    ProductResult createProduct(CreateProductCommand command);

    ProductResult activateProduct(ActivateProductCommand command);

    ProductVersionResult createProductVersion(CreateProductVersionCommand command);

    ProductVersionResult updateProductVersion(UpdateProductVersionCommand command);

    ProductVersionResult publishProductVersion(PublishProductVersionCommand command);

    PublishedProductVersion obtainPublishedProductVersion(ProductId productId, LocalDate referenceDate);
}
