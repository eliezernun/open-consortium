package org.consortiumcore.productcatalog.domain.exception;

import org.consortiumcore.productcatalog.domain.error.ProductCatalogError;

public final class InvalidQuotaCapacityException extends ProductDomainException {

    public InvalidQuotaCapacityException() {
        super(ProductCatalogError.INVALID_QUOTA_CAPACITY);
    }
}
