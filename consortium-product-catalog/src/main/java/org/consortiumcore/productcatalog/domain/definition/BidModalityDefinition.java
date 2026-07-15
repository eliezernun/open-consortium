package org.consortiumcore.productcatalog.domain.definition;

import org.consortiumcore.productcatalog.domain.type.BidModalityCode;

public sealed interface BidModalityDefinition
        permits FreeBidDefinition,
        FixedBidDefinition,
        EmbeddedBidDefinition {

    BidModalityCode code();
}