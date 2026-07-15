package org.consortiumcore.productcatalog.domain.definition;

import java.util.Currency;
import org.consortiumcore.productcatalog.domain.type.CreditModel;

public record CreditDefinition(
        CreditModel model,
        MonetaryRange allowedRange,
        Currency currency,
        boolean allowsMultipleCreditPlans,
        int maximumCreditPlans,
        CreditUtilizationDefinition utilization
) {
}