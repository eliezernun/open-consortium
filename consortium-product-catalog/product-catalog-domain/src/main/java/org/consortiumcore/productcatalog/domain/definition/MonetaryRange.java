package org.consortiumcore.productcatalog.domain.definition;

import org.consortiumcore.productcatalog.domain.error.Required;
import org.consortiumcore.productcatalog.domain.exception.CurrencyMismatchException;
import org.consortiumcore.productcatalog.domain.exception.InvalidMonetaryRangeException;

public record MonetaryRange(
        Money minimum,
        Money maximum
) {

    public MonetaryRange {
        Required.notNull(minimum, "monetaryRange.minimum");
        Required.notNull(maximum, "monetaryRange.maximum");

        if (!minimum.currency().equals(maximum.currency())) {
            throw new CurrencyMismatchException();
        }

        if (maximum.isLessThan(minimum)) {
            throw new InvalidMonetaryRangeException();
        }
    }

    public boolean includes(Money value) {
        return !value.isLessThan(minimum)
                && !value.isGreaterThan(maximum);
    }
}
