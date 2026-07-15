package org.consortiumcore.productcatalog.domain.definition;

import org.consortiumcore.productcatalog.domain.type.ClosureTrigger;

public record ClosureDefinition(
        ClosureTrigger trigger,
        boolean requiresAllQuotasResolved,
        boolean requiresPendingRestitutionsIdentified,
        boolean requiresRemainingResourcesCalculation,
        RemainingResourceDefinition remainingResources
) {
}