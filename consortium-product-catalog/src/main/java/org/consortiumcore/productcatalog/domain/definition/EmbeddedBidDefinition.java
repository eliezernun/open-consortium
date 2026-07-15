package org.consortiumcore.productcatalog.domain.definition;

import org.consortiumcore.productcatalog.domain.type.BidModalityCode;

public record EmbeddedBidDefinition(
        Percentage maximumCreditPercentage,
        boolean combinableWithOwnResources
) implements BidModalityDefinition {

    @Override
    public BidModalityCode code() {
        return BidModalityCode.EMBEDDED;
    }
}