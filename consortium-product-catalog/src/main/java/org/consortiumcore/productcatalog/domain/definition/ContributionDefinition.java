package org.consortiumcore.productcatalog.domain.definition;

import org.consortiumcore.productcatalog.domain.type.ContributionCalculationBasis;

import org.consortiumcore.productcatalog.domain.type.ContributionFrequency;

public record ContributionDefinition(
        ContributionFrequency frequency,
        ContributionCalculationBasis calculationBasis,
        boolean allowsPartialPayment,
        boolean allowsAdvancePayment,
        AllocationOrder allocationOrder
) {
}