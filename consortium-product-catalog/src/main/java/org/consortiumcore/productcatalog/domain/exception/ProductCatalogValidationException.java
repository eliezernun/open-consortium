package org.consortiumcore.productcatalog.domain.exception;

import org.consortiumcore.productcatalog.domain.error.ProductCatalogError;

public final class ProductCatalogValidationException extends ProductDomainException {

    public ProductCatalogValidationException(ProductCatalogError error, Object... arguments) {
        super(error, arguments);
    }
}
