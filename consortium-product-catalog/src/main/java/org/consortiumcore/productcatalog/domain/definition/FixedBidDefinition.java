package org.consortiumcore.productcatalog.domain.definition;

import org.consortiumcore.productcatalog.domain.type.BidModalityCode;

import java.util.Set;

public record FixedBidDefinition(
        Set<Percentage> allowedPercentages
) implements BidModalityDefinition {

    @Override
    public BidModalityCode code() {
        return BidModalityCode.FIXED;
    }
}