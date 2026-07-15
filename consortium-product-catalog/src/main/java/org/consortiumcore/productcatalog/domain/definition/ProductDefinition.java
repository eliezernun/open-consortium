package org.consortiumcore.productcatalog.domain.definition;

import java.util.Objects;

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
        Objects.requireNonNull(group);
        Objects.requireNonNull(credit);
        Objects.requireNonNull(duration);
        Objects.requireNonNull(contribution);
        Objects.requireNonNull(administrationFee);
        Objects.requireNonNull(adjustment);
        Objects.requireNonNull(assembly);
        Objects.requireNonNull(draw);
        Objects.requireNonNull(bid);
        Objects.requireNonNull(exclusion);
        Objects.requireNonNull(readmission);
        Objects.requireNonNull(transfer);
        Objects.requireNonNull(closure);
    }
}