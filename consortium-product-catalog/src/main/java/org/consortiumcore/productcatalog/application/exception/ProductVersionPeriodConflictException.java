package org.consortiumcore.productcatalog.application.exception;

import org.consortiumcore.productcatalog.domain.error.ProductCatalogError;
import org.consortiumcore.productcatalog.domain.exception.ProductDomainException;
import org.consortiumcore.productcatalog.domain.version.ProductVersionId;

public final class ProductVersionPeriodConflictException extends ProductDomainException {

    public ProductVersionPeriodConflictException(ProductVersionId conflictingVersionId) {
        super(ProductCatalogError.PRODUCT_VERSION_PERIOD_CONFLICT, conflictingVersionId.value());
    }
}
