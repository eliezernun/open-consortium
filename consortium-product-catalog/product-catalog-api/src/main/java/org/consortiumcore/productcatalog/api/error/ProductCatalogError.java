package org.consortiumcore.productcatalog.api.error;

public enum ProductCatalogError {
    PRODUCT_NOT_FOUND("PRODUCT_CATALOG.PRODUCT_NOT_FOUND", "product-catalog.product.not-found"),
    PRODUCT_VERSION_NOT_FOUND("PRODUCT_CATALOG.PRODUCT_VERSION_NOT_FOUND", "product-catalog.product-version.not-found"),
    PRODUCT_VERSION_PERIOD_CONFLICT("PRODUCT_CATALOG.PRODUCT_VERSION_PERIOD_CONFLICT", "product-catalog.product-version.period-conflict"),
    EFFECTIVE_PUBLISHED_VERSION_NOT_FOUND("PRODUCT_CATALOG.EFFECTIVE_PUBLISHED_VERSION_NOT_FOUND", "product-catalog.product-version.effective-published-not-found"),
    DUPLICATED_PRODUCT_CODE("PRODUCT_CATALOG.DUPLICATED_PRODUCT_CODE", "product-catalog.product.duplicated-code"),
    INVALID_PRODUCT_DEFINITION("PRODUCT_CATALOG.INVALID_PRODUCT_VERSION_DEFINITION", "product-catalog.product-version.invalid-definition"),
    INVALID_PRODUCT_STATUS("PRODUCT_CATALOG.INVALID_PRODUCT_STATUS_TRANSITION", "product-catalog.product.invalid-status-transition");

    private final String code;
    private final String messageKey;

    ProductCatalogError(String code, String messageKey) {
        this.code = code;
        this.messageKey = messageKey;
    }

    public String code() {
        return code;
    }

    public String messageKey() {
        return messageKey;
    }
}
