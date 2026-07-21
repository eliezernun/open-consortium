package org.consortiumcore.productcatalog.domain.exception;

import org.consortiumcore.productcatalog.domain.product.ProductId;
import org.consortiumcore.productcatalog.domain.error.ProductCatalogError;

public final class ProductAlreadyRetiredException extends ProductDomainException {

    public ProductAlreadyRetiredException(ProductId productId) {
        super(ProductCatalogError.PRODUCT_ALREADY_RETIRED, productId.value());
    }
}
