package org.consortiumcore.productcatalog.domain.definition;

import org.consortiumcore.productcatalog.domain.type.EligibilityRestriction;

import java.util.Set;

public record EligibilityDefinition(
        boolean requiresActiveQuota,
        boolean requiresPaymentUpToDate,
        EligibilityCutoffDefinition cutoff,
        Set<EligibilityRestriction> restrictions
) {
}