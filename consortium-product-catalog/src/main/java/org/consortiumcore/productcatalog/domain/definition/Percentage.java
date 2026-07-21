package org.consortiumcore.productcatalog.domain.definition;

import java.math.BigDecimal;
import org.consortiumcore.productcatalog.domain.error.Required;
import org.consortiumcore.productcatalog.domain.exception.InvalidPercentageException;

public record Percentage(BigDecimal value) {

    public Percentage {
        Required.notNull(value, "percentage.value");

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
