package org.consortiumcore.productcatalog.domain.exception;

import org.consortiumcore.productcatalog.domain.error.ProductCatalogError;

public final class InvalidMonthRangeException extends ProductDomainException {

    public InvalidMonthRangeException() {
        super(ProductCatalogError.INVALID_MONTH_RANGE);
    }
}
