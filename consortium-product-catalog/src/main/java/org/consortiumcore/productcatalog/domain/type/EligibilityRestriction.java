package org.consortiumcore.productcatalog.domain.type;
/*
    No catálogo, isso é definição.
    A avaliação real pertence ao módulo de assembleia.
 */
public enum EligibilityRestriction {
    EXCLUDED_QUOTA,
    CANCELLED_QUOTA,
    ALREADY_CONTEMPLATED,
    PAYMENT_AFTER_CUTOFF,
    LEGAL_BLOCK,
    CONTRACTUAL_BLOCK
}
