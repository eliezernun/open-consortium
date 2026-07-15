package org.consortiumcore.productcatalog.domain.definition;

public record ReadmissionDefinition(
        boolean allowed,
        boolean requiresAvailableCapacity,
        boolean requiresDebtRecomposition,
        boolean requiresViabilityReassessment,
        ReadmissionCalculationDefinition calculation
) {
}