package org.consortiumcore.productcatalog.domain.definition;

import org.consortiumcore.productcatalog.domain.type.BidComparisonBasis;

import org.consortiumcore.productcatalog.domain.type.BidModalityCode;

public record FreeBidDefinition(
        BidComparisonBasis comparisonBasis,
        Percentage minimumPercentage
) implements BidModalityDefinition {

    @Override
    public BidModalityCode code() {
        return BidModalityCode.FREE;
    }
}