package org.consortiumcore.productcatalog.domain.definition;

import org.consortiumcore.productcatalog.domain.error.Required;

public record ProductDefinition(
        GroupDefinition group,
        CreditDefinition credit,
        DurationDefinition duration,
        ContributionDefinition contribution,
        AdministrationFeeDefinition administrationFee,
        ReserveFundDefinition reserveFund,
        AdjustmentDefinition adjustment,
        AssemblyDefinition assembly,
        DrawDefinition draw,
        BidDefinition bid,
        ExclusionDefinition exclusion,
        ReadmissionDefinition readmission,
        TransferDefinition transfer,
        ClosureDefinition closure
) {

    public ProductDefinition {
        Required.notNull(group, "definition.group");
        Required.notNull(credit, "definition.credit");
        Required.notNull(duration, "definition.duration");
        Required.notNull(contribution, "definition.contribution");
        Required.notNull(administrationFee, "definition.administrationFee");
        Required.notNull(adjustment, "definition.adjustment");
        Required.notNull(assembly, "definition.assembly");
        Required.notNull(draw, "definition.draw");
        Required.notNull(bid, "definition.bid");
        Required.notNull(exclusion, "definition.exclusion");
        Required.notNull(readmission, "definition.readmission");
        Required.notNull(transfer, "definition.transfer");
        Required.notNull(closure, "definition.closure");
    }
}
