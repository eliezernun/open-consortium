package org.consortiumcore.productcatalog.domain.definition;

public record GroupDefinition(
        QuotaCapacityRange quotaCapacity,
        boolean requiresEconomicViabilityAssessment
) {
}
