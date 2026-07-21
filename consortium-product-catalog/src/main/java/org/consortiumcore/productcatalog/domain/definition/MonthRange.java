package org.consortiumcore.productcatalog.domain.definition;

import org.consortiumcore.productcatalog.domain.exception.InvalidMonthRangeException;

public record MonthRange(
        int minimum,
        int maximum
) {

    public MonthRange {
        if (minimum <= 0 || maximum < minimum) {
            throw new InvalidMonthRangeException();
        }
    }

    public boolean accepts(int months) {
        return months >= minimum && months <= maximum;
    }
}
