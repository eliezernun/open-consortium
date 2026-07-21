package org.consortiumcore.productcatalog.domain.exception;

import org.consortiumcore.productcatalog.domain.error.ProductCatalogError;

public final class InvalidAllocationOrderException extends ProductDomainException {

    public InvalidAllocationOrderException() {
        super(ProductCatalogError.INVALID_ALLOCATION_ORDER);
    }
}
