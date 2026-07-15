package org.consortiumcore.productcatalog.domain.definition;

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