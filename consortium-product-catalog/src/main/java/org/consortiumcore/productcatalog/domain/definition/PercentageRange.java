package org.consortiumcore.productcatalog.domain.definition;

import java.util.Objects;

public record PercentageRange(
        Percentage minimum,
        Percentage maximum
) {

    public PercentageRange {
        Objects.requireNonNull(minimum);
        Objects.requireNonNull(maximum);

        if (maximum.value().compareTo(minimum.value()) < 0) {
            throw new InvalidPercentageRangeException();
        }
    }
}