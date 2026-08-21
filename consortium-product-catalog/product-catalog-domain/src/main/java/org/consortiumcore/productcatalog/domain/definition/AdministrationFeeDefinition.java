package org.consortiumcore.productcatalog.domain.definition;

import org.consortiumcore.productcatalog.domain.error.Required;

public record AdministrationFeeDefinition(
        PercentageRange allowedRate
) {

    public AdministrationFeeDefinition {
        Required.notNull(allowedRate, "administrationFee.allowedRate");
    }
}
