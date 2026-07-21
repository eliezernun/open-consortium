package org.consortiumcore.productcatalog.domain.exception;

import org.consortiumcore.productcatalog.domain.error.ProductCatalogError;

public final class InvalidPercentageRangeException extends ProductDomainException {

    public InvalidPercentageRangeException() {
        super(ProductCatalogError.INVALID_PERCENTAGE_RANGE);
    }
}
