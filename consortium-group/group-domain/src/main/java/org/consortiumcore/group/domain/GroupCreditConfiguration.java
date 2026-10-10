package org.consortiumcore.group.domain;

import java.math.BigDecimal;
import java.util.Currency;
import org.consortiumcore.shared.error.Required;

public record GroupCreditConfiguration(
        BigDecimal minimumAmount,
        BigDecimal maximumAmount,
        Currency currency,
        boolean allowsMultipleCreditPlans
) {

    public GroupCreditConfiguration {
        Required.notNull(minimumAmount, GroupError.REQUIRED_VALUE, "groupCredit.minimumAmount");
        Required.notNull(maximumAmount, GroupError.REQUIRED_VALUE, "groupCredit.maximumAmount");
        Required.notNull(currency, GroupError.REQUIRED_VALUE, "groupCredit.currency");
        minimumAmount = minimumAmount.stripTrailingZeros();
        maximumAmount = maximumAmount.stripTrailingZeros();
        if (minimumAmount.signum() < 0 || maximumAmount.compareTo(minimumAmount) < 0) {
            throw new GroupDomainException(GroupError.INVALID_GROUP_CREDIT_CONFIGURATION);
        }
    }
}
