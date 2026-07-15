package org.consortiumcore.productcatalog.domain.definition;

import java.math.BigDecimal;
import java.util.Objects;

public record Percentage(BigDecimal value) {

    public Percentage {
        Objects.requireNonNull(value);

        if (value.compareTo(BigDecimal.ZERO) < 0) {
            throw new InvalidPercentageException(value);
        }
    }

    public static Percentage ofPercent(String percent) {
        return new Percentage(
                new BigDecimal(percent)
                        .divide(new BigDecimal("100"))
        );
    }
}