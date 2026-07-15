package org.consortiumcore.productcatalog.domain.definition;

import org.consortiumcore.productcatalog.domain.type.AdjustmentFrequency;
import org.consortiumcore.productcatalog.domain.type.AdjustmentType;

public record AdjustmentDefinition(
        AdjustmentType type,
        AdjustmentFrequency frequency,
        ReferenceIndexCode referenceIndex,
        AdjustmentApplication application,
        RoundingPolicy roundingPolicy
) {
}