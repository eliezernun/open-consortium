package org.consortiumcore.productcatalog.domain.definition;

public record ReadmissionCalculationDefinition(
        boolean appliesInterest,
        boolean appliesPenalty,
        boolean recalculatesCreditDifferences,
        boolean redistributesOutstandingBalance
) {
}