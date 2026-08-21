package org.consortiumcore.productcatalog.domain.exception;

import org.consortiumcore.productcatalog.domain.version.ProductVersionId;
import org.consortiumcore.productcatalog.domain.error.ProductCatalogError;

public final class PublishedProductVersionCannotBeModifiedException extends ProductDomainException {

    public PublishedProductVersionCannotBeModifiedException(ProductVersionId versionId) {
        super(ProductCatalogError.PUBLISHED_PRODUCT_VERSION_CANNOT_BE_MODIFIED, versionId.value());
    }
}
