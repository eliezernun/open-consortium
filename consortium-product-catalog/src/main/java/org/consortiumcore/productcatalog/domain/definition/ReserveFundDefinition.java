package org.consortiumcore.productcatalog.domain.definition;

import org.consortiumcore.productcatalog.domain.type.ReserveFundPurpose;

import java.util.Set;

public record ReserveFundDefinition(
        boolean enabled,
        PercentageRange allowedRate,
        Set<ReserveFundPurpose> allowedPurposes,
        RemainingBalanceDestination remainingBalanceDestination
) {

    public static ReserveFundDefinition disabled() {
        return new ReserveFundDefinition(
                false,
                PercentageRange.zero(),
                Set.of(),
                RemainingBalanceDestination.NOT_APPLICABLE
        );
    }
}