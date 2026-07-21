package org.consortiumcore.productcatalog.domain.definition;

import org.consortiumcore.productcatalog.domain.error.Required;
import org.consortiumcore.productcatalog.domain.exception.InvalidPercentageRangeException;

public record PercentageRange(
        Percentage minimum,
        Percentage maximum
) {

    public PercentageRange {
        Required.notNull(minimum, "percentageRange.minimum");
        Required.notNull(maximum, "percentageRange.maximum");

        if (maximum.value().compareTo(minimum.value()) < 0) {
            throw new InvalidPercentageRangeException();
        }
    }

    public static PercentageRange zero() {
        Percentage zero = new Percentage(java.math.BigDecimal.ZERO);
        return new PercentageRange(zero, zero);
    }
}
