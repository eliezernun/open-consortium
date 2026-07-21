package org.consortiumcore.productcatalog.domain.definition;

import java.math.BigDecimal;
import java.util.Currency;
import org.consortiumcore.productcatalog.domain.error.ProductCatalogError;
import org.consortiumcore.productcatalog.domain.error.Required;
import org.consortiumcore.productcatalog.domain.exception.ProductCatalogValidationException;

public record Money(BigDecimal amount, Currency currency) {

    public Money {
        Required.notNull(amount, "money.amount");
        Required.notNull(currency, "money.currency");

        if (amount.signum() < 0) {
            throw new ProductCatalogValidationException(ProductCatalogError.INVALID_MONEY);
        }

        amount = amount.stripTrailingZeros();
    }

    public boolean isLessThan(Money other) {
        assertSameCurrency(other);
        return amount.compareTo(other.amount) < 0;
    }

    public boolean isGreaterThan(Money other) {
        assertSameCurrency(other);
        return amount.compareTo(other.amount) > 0;
    }

    private void assertSameCurrency(Money other) {
        Required.notNull(other, "money.other");
        if (!currency.equals(other.currency)) {
            throw new ProductCatalogValidationException(ProductCatalogError.CURRENCY_MISMATCH);
        }
    }
}
