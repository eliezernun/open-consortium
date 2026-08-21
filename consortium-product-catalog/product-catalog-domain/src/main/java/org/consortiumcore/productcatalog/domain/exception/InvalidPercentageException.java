package org.consortiumcore.productcatalog.domain.exception;

import java.math.BigDecimal;
import org.consortiumcore.productcatalog.domain.error.ProductCatalogError;

public final class InvalidPercentageException extends ProductDomainException {

    public InvalidPercentageException(BigDecimal value) {
        super(ProductCatalogError.INVALID_PERCENTAGE, value);
    }
}
