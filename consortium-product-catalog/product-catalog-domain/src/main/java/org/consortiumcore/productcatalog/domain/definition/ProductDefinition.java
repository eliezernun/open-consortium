package org.consortiumcore.productcatalog.domain.definition;

import org.consortiumcore.productcatalog.domain.error.Required;

public record ProductDefinition(
        GroupDefinition group,
        CreditDefinition credit,
        DurationDefinition duration,
        AdministrationFeeDefinition administrationFee,
        ReserveFundDefinition reserveFund,
        AdjustmentDefinition adjustment,
        AssemblyDefinition assembly
) {

    public ProductDefinition {
        Required.notNull(group, "definition.group");
        Required.notNull(credit, "definition.credit");
        Required.notNull(duration, "definition.duration");
        Required.notNull(administrationFee, "definition.administrationFee");
        Required.notNull(reserveFund, "definition.reserveFund");
        Required.notNull(adjustment, "definition.adjustment");
        Required.notNull(assembly, "definition.assembly");
    }
}
