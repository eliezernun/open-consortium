package org.consortiumcore.productcatalog.domain.exception;

import org.consortiumcore.productcatalog.domain.error.ProductCatalogError;

public final class InvalidProductCodeException extends ProductDomainException {

    public InvalidProductCodeException(String value) {
        super(ProductCatalogError.INVALID_PRODUCT_CODE, value);
    }
}
