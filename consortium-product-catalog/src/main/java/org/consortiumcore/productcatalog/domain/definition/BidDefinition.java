package org.consortiumcore.productcatalog.domain.definition;

import java.util.Set;

public record BidDefinition(
        Set<BidModalityDefinition> modalities,
        BidTieBreakDefinition tieBreak,
        BidSubmissionDefinition submission
) {
}