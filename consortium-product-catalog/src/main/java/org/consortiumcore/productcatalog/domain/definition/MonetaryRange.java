package org.consortiumcore.productcatalog.domain.definition;

import java.util.Objects;

public record MonetaryRange(
        Money minimum,
        Money maximum
) {

    public MonetaryRange {
        Objects.requireNonNull(minimum);
        Objects.requireNonNull(maximum);

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