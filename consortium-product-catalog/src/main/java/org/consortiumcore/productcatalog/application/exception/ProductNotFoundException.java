package org.consortiumcore.productcatalog.application.exception;

import org.consortiumcore.productcatalog.domain.error.ProductCatalogError;
import org.consortiumcore.productcatalog.domain.exception.ProductDomainException;
import org.consortiumcore.productcatalog.domain.product.ProductId;

public final class ProductNotFoundException extends ProductDomainException {

    public ProductNotFoundException(ProductId productId) {
        super(ProductCatalogError.PRODUCT_NOT_FOUND, productId.value());
    }
}
