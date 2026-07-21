package org.consortiumcore.productcatalog.application.exception;

import org.consortiumcore.productcatalog.domain.error.ProductCatalogError;
import org.consortiumcore.productcatalog.domain.exception.ProductDomainException;
import org.consortiumcore.productcatalog.domain.version.ProductVersionId;

public final class ProductVersionNotFoundException extends ProductDomainException {

    public ProductVersionNotFoundException(ProductVersionId productVersionId) {
        super(ProductCatalogError.PRODUCT_VERSION_NOT_FOUND, productVersionId.value());
    }
}
