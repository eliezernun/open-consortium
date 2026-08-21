package org.consortiumcore.productcatalog.domain.exception;

import org.consortiumcore.productcatalog.domain.error.ProductCatalogError;

public final class InvalidMonetaryRangeException extends ProductDomainException {

    public InvalidMonetaryRangeException() {
        super(ProductCatalogError.INVALID_MONETARY_RANGE);
    }
}
