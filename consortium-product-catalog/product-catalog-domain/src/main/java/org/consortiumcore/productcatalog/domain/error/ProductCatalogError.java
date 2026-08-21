package org.consortiumcore.productcatalog.domain.error;

import org.consortiumcore.shared.error.ApplicationError;

public enum ProductCatalogError implements ApplicationError {
    PRODUCT_NOT_FOUND(
            "PRODUCT_CATALOG.PRODUCT_NOT_FOUND",
            "product-catalog.product.not-found",
            "Product not found: {0}"
    ),
    PRODUCT_VERSION_NOT_FOUND(
            "PRODUCT_CATALOG.PRODUCT_VERSION_NOT_FOUND",
            "product-catalog.product-version.not-found",
            "Product version not found: {0}"
    ),
    PRODUCT_VERSION_PERIOD_CONFLICT(
            "PRODUCT_CATALOG.PRODUCT_VERSION_PERIOD_CONFLICT",
            "product-catalog.product-version.period-conflict",
            "Effective period conflicts with published product version: {0}"
    ),
    EFFECTIVE_PUBLISHED_VERSION_NOT_FOUND(
            "PRODUCT_CATALOG.EFFECTIVE_PUBLISHED_VERSION_NOT_FOUND",
            "product-catalog.product-version.effective-published-not-found",
            "No published product version is effective for the requested date."
    ),
    DUPLICATED_PRODUCT_CODE(
            "PRODUCT_CATALOG.DUPLICATED_PRODUCT_CODE",
            "product-catalog.product.duplicated-code",
            "Product code already exists: {0}"
    ),
    INVALID_PRODUCT_CODE(
            "PRODUCT_CATALOG.INVALID_PRODUCT_CODE",
            "product-catalog.product.invalid-code",
            "Invalid product code: {0}"
    ),
    INVALID_PRODUCT_NAME(
            "PRODUCT_CATALOG.INVALID_PRODUCT_NAME",
            "product-catalog.product.invalid-name",
            "Invalid product name: {0}"
    ),
    INVALID_PRODUCT_STATUS_TRANSITION(
            "PRODUCT_CATALOG.INVALID_PRODUCT_STATUS_TRANSITION",
            "product-catalog.product.invalid-status-transition",
            "Invalid product status transition: {0} -> {1}"
    ),
    PRODUCT_ALREADY_RETIRED(
            "PRODUCT_CATALOG.PRODUCT_ALREADY_RETIRED",
            "product-catalog.product.already-retired",
            "Retired product cannot be activated: {0}"
    ),
    RETIRED_PRODUCT_CANNOT_RECEIVE_VERSION(
            "PRODUCT_CATALOG.RETIRED_PRODUCT_CANNOT_RECEIVE_VERSION",
            "product-catalog.product.retired-cannot-receive-version",
            "Retired product cannot receive a new version."
    ),
    PRODUCT_TYPE_NOT_REGISTERED(
            "PRODUCT_CATALOG.PRODUCT_TYPE_NOT_REGISTERED",
            "product-catalog.product-type.not-registered",
            "Product type is not registered: {0}"
    ),
    INVALID_PRODUCT_TYPE_DEFINITION(
            "PRODUCT_CATALOG.INVALID_PRODUCT_TYPE_DEFINITION",
            "product-catalog.product-type.invalid-definition",
            "Product definition is not valid for product type: {0}"
    ),
    PUBLISHED_PRODUCT_VERSION_CANNOT_BE_MODIFIED(
            "PRODUCT_CATALOG.PUBLISHED_PRODUCT_VERSION_CANNOT_BE_MODIFIED",
            "product-catalog.product-version.published-cannot-be-modified",
            "Published product version cannot be modified: {0}"
    ),
    INVALID_EFFECTIVE_PERIOD(
            "PRODUCT_CATALOG.INVALID_EFFECTIVE_PERIOD",
            "product-catalog.product-version.invalid-effective-period",
            "Invalid effective period: {0} -> {1}"
    ),
    INVALID_CONFIGURATION_HASH_ALGORITHM(
            "PRODUCT_CATALOG.INVALID_CONFIGURATION_HASH_ALGORITHM",
            "product-catalog.configuration-hash.invalid-algorithm",
            "SHA-256 is not available."
    ),
    INVALID_PERCENTAGE(
            "PRODUCT_CATALOG.INVALID_PERCENTAGE",
            "product-catalog.definition.invalid-percentage",
            "Invalid percentage: {0}"
    ),
    INVALID_PERCENTAGE_RANGE(
            "PRODUCT_CATALOG.INVALID_PERCENTAGE_RANGE",
            "product-catalog.definition.invalid-percentage-range",
            "Invalid percentage range."
    ),
    INVALID_ALLOCATION_ORDER(
            "PRODUCT_CATALOG.INVALID_ALLOCATION_ORDER",
            "product-catalog.definition.invalid-allocation-order",
            "Allocation order must contain at least one component."
    ),
    INVALID_MONTH_RANGE(
            "PRODUCT_CATALOG.INVALID_MONTH_RANGE",
            "product-catalog.definition.invalid-month-range",
            "Invalid month range."
    ),
    CURRENCY_MISMATCH(
            "PRODUCT_CATALOG.CURRENCY_MISMATCH",
            "product-catalog.definition.currency-mismatch",
            "Money range currencies must match."
    ),
    INVALID_MONEY(
            "PRODUCT_CATALOG.INVALID_MONEY",
            "product-catalog.definition.invalid-money",
            "Invalid money value."
    ),
    INVALID_MONETARY_RANGE(
            "PRODUCT_CATALOG.INVALID_MONETARY_RANGE",
            "product-catalog.definition.invalid-monetary-range",
            "Invalid monetary range."
    ),
    INVALID_QUOTA_CAPACITY(
            "PRODUCT_CATALOG.INVALID_QUOTA_CAPACITY",
            "product-catalog.definition.invalid-quota-capacity",
            "Invalid quota capacity."
    ),
    INVALID_FORMATION_PERIOD(
            "PRODUCT_CATALOG.INVALID_FORMATION_PERIOD",
            "product-catalog.definition.invalid-formation-period",
            "Invalid formation period."
    ),
    INVALID_REGULATION_SET_ID(
            "PRODUCT_CATALOG.INVALID_REGULATION_SET_ID",
            "product-catalog.regulation.invalid-set-id",
            "Regulation set id is required."
    ),
    INVALID_BID_SUBMISSION_DEADLINE(
            "PRODUCT_CATALOG.INVALID_BID_SUBMISSION_DEADLINE",
            "product-catalog.definition.invalid-bid-submission-deadline",
            "Bid submission deadline cannot be negative."
    ),
    INVALID_ELIGIBILITY_CUTOFF(
            "PRODUCT_CATALOG.INVALID_ELIGIBILITY_CUTOFF",
            "product-catalog.definition.invalid-eligibility-cutoff",
            "Eligibility cutoff cannot be negative."
    ),
    INVALID_EXCLUSION_NOTIFICATION_PERIOD(
            "PRODUCT_CATALOG.INVALID_EXCLUSION_NOTIFICATION_PERIOD",
            "product-catalog.definition.invalid-exclusion-notification-period",
            "Exclusion notification period cannot be negative."
    ),
    INVALID_ROUNDING_POLICY(
            "PRODUCT_CATALOG.INVALID_ROUNDING_POLICY",
            "product-catalog.definition.invalid-rounding-policy",
            "Rounding scale cannot be negative."
    ),
    INVALID_DRAW_SOURCE(
            "PRODUCT_CATALOG.INVALID_DRAW_SOURCE",
            "product-catalog.definition.invalid-draw-source",
            "Draw source is required."
    ),
    INVALID_PRODUCT_VERSION_DEFINITION(
            "PRODUCT_CATALOG.INVALID_PRODUCT_VERSION_DEFINITION",
            "product-catalog.product-version.invalid-definition",
            "Product version definition is invalid: {0}"
    ),
    INVALID_VERSION_NUMBER(
            "PRODUCT_CATALOG.INVALID_VERSION_NUMBER",
            "product-catalog.product-version.invalid-version-number",
            "Version number must be greater than zero."
    ),
    REQUIRED_VALUE(
            "PRODUCT_CATALOG.REQUIRED_VALUE",
            "product-catalog.required-value",
            "Required value is missing: {0}"
    );

    private final String code;
    private final String messageKey;
    private final String defaultMessage;

    ProductCatalogError(String code, String messageKey, String defaultMessage) {
        this.code = code;
        this.messageKey = messageKey;
        this.defaultMessage = defaultMessage;
    }

    @Override
    public String code() {
        return code;
    }

    @Override
    public String messageKey() {
        return messageKey;
    }

    @Override
    public String defaultMessage() {
        return defaultMessage;
    }
}
