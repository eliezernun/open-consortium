package org.consortiumcore.productcatalog.domain.definition;

import java.util.List;
import org.consortiumcore.productcatalog.domain.type.BidTieBreakCriterion;

public record BidTieBreakDefinition(
        List<BidTieBreakCriterion> criteria
) {
}