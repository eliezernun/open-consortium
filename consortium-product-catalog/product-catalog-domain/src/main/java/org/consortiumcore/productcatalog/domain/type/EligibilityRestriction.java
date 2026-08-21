package org.consortiumcore.productcatalog.domain.type;

/*
    In the catalog this is only a definition.
    The actual evaluation belongs to the assembly module.
 */
public enum EligibilityRestriction {
    EXCLUDED_QUOTA,
    CANCELLED_QUOTA,
    ALREADY_CONTEMPLATED,
    PAYMENT_AFTER_CUTOFF,
    LEGAL_BLOCK,
    CONTRACTUAL_BLOCK
}
