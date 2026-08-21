package org.consortiumcore.productcatalog.domain.exception;

import org.consortiumcore.productcatalog.domain.error.ProductCatalogError;

public final class InvalidProductNameException extends ProductDomainException {

    public InvalidProductNameException(String value) {
        super(ProductCatalogError.INVALID_PRODUCT_NAME, value);
    }
}
