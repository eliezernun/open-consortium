package org.consortiumcore.productcatalog.domain.definition;

public record RemainingResourceDefinition(
        RemainingBalanceDestination destination,
        boolean requiresProportionalAllocation
) {
}
