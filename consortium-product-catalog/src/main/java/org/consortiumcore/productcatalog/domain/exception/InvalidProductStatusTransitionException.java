package org.consortiumcore.productcatalog.domain.exception;

import org.consortiumcore.productcatalog.domain.product.ProductStatus;
import org.consortiumcore.productcatalog.domain.error.ProductCatalogError;

public final class InvalidProductStatusTransitionException extends ProductDomainException {

    public InvalidProductStatusTransitionException(ProductStatus current, ProductStatus target) {
        super(ProductCatalogError.INVALID_PRODUCT_STATUS_TRANSITION, current, target);
    }
}
