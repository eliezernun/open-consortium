package org.consortiumcore.productcatalog.domain.definition;

import org.consortiumcore.productcatalog.domain.error.Required;

public record ReserveFundDefinition(
        boolean enabled,
        PercentageRange allowedRate
) {

    public ReserveFundDefinition {
        Required.notNull(allowedRate, "reserveFund.allowedRate");
    }

    public static ReserveFundDefinition disabled() {
        return new ReserveFundDefinition(
                false,
                PercentageRange.zero()
        );
    }
}
