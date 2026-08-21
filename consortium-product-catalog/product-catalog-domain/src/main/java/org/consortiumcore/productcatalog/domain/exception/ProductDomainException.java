package org.consortiumcore.productcatalog.domain.exception;

import org.consortiumcore.productcatalog.domain.error.ProductCatalogError;
import org.consortiumcore.shared.error.ApplicationException;

public class ProductDomainException extends ApplicationException {

    public ProductDomainException(ProductCatalogError error, Object... arguments) {
        super(error, arguments);
    }
}
