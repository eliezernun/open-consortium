package org.consortiumcore.productcatalog.domain.exception;

import org.consortiumcore.productcatalog.domain.error.ProductCatalogError;

public final class CurrencyMismatchException extends ProductDomainException {

    public CurrencyMismatchException() {
        super(ProductCatalogError.CURRENCY_MISMATCH);
    }
}
