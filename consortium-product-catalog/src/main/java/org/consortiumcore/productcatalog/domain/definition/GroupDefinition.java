package org.consortiumcore.productcatalog.domain.definition;

public record GroupDefinition(
        QuotaCapacityRange quotaCapacity,
        FormationPeriodDefinition formationPeriod,
        boolean allowsQuotaReplacement,
        boolean requiresEconomicViabilityAssessment
) {
}