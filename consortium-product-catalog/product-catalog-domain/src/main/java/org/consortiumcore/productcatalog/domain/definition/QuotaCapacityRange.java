package org.consortiumcore.productcatalog.domain.definition;

import org.consortiumcore.productcatalog.domain.exception.InvalidQuotaCapacityException;

public record QuotaCapacityRange(
        int minimum,
        int maximum
) {

    public QuotaCapacityRange {
        if (minimum <= 0) {
            throw new InvalidQuotaCapacityException();
        }

        if (maximum < minimum) {
            throw new InvalidQuotaCapacityException();
        }
    }

    public boolean accepts(int quantity) {
        return quantity >= minimum && quantity <= maximum;
    }
}
