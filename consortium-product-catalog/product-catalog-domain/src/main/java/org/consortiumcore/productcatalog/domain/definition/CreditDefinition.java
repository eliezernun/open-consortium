package org.consortiumcore.productcatalog.domain.definition;

import java.util.Currency;
import org.consortiumcore.productcatalog.domain.error.Required;
import org.consortiumcore.productcatalog.domain.exception.CurrencyMismatchException;

public record CreditDefinition(
        MonetaryRange allowedRange,
        Currency currency,
        boolean allowsMultipleCreditPlans
) {

    public CreditDefinition {
        Required.notNull(allowedRange, "credit.allowedRange");
        Required.notNull(currency, "credit.currency");
        if (!allowedRange.minimum().currency().equals(currency)
                || !allowedRange.maximum().currency().equals(currency)) {
            throw new CurrencyMismatchException();
        }
    }
}
