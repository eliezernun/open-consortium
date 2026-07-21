package org.consortiumcore.productcatalog.domain.exception;

import java.time.LocalDate;
import org.consortiumcore.productcatalog.domain.error.ProductCatalogError;

public final class InvalidEffectivePeriodException extends ProductDomainException {

    public InvalidEffectivePeriodException(LocalDate from, LocalDate until) {
        super(ProductCatalogError.INVALID_EFFECTIVE_PERIOD, from, until);
    }
}
