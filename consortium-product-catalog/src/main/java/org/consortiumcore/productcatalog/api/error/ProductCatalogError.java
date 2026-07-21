package org.consortiumcore.productcatalog.api.error;

public enum ProductCatalogError {
    PRODUCT_NOT_FOUND(org.consortiumcore.productcatalog.domain.error.ProductCatalogError.PRODUCT_NOT_FOUND),
    PRODUCT_VERSION_NOT_FOUND(org.consortiumcore.productcatalog.domain.error.ProductCatalogError.PRODUCT_VERSION_NOT_FOUND),
    PRODUCT_VERSION_PERIOD_CONFLICT(org.consortiumcore.productcatalog.domain.error.ProductCatalogError.PRODUCT_VERSION_PERIOD_CONFLICT),
    EFFECTIVE_PUBLISHED_VERSION_NOT_FOUND(org.consortiumcore.productcatalog.domain.error.ProductCatalogError.EFFECTIVE_PUBLISHED_VERSION_NOT_FOUND),
    DUPLICATED_PRODUCT_CODE(org.consortiumcore.productcatalog.domain.error.ProductCatalogError.DUPLICATED_PRODUCT_CODE),
    INVALID_PRODUCT_DEFINITION(org.consortiumcore.productcatalog.domain.error.ProductCatalogError.INVALID_PRODUCT_VERSION_DEFINITION),
    INVALID_PRODUCT_STATUS(org.consortiumcore.productcatalog.domain.error.ProductCatalogError.INVALID_PRODUCT_STATUS_TRANSITION);

    private final org.consortiumcore.productcatalog.domain.error.ProductCatalogError error;

    ProductCatalogError(org.consortiumcore.productcatalog.domain.error.ProductCatalogError error) {
        this.error = error;
    }

    public String code() {
        return error.code();
    }

    public String messageKey() {
        return error.messageKey();
    }
}
