package org.consortiumcore.productcatalog.domain.definition;

import org.consortiumcore.productcatalog.domain.type.AdjustmentType;

public record AdjustmentDefinition(
        AdjustmentType type,
        ReferenceIndexCode referenceIndex
) {
}
