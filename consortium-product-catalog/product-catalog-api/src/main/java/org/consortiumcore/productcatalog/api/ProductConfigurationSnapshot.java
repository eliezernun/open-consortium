package org.consortiumcore.productcatalog.api;

import java.math.BigDecimal;
import java.util.Currency;

public record ProductConfigurationSnapshot(
        GroupConfiguration group,
        CreditConfiguration credit,
        DurationConfiguration duration,
        PercentageRangeConfiguration administrationFee,
        ReserveFundConfiguration reserveFund,
        AdjustmentConfiguration adjustment,
        AssemblyConfiguration assembly
) {

    public record GroupConfiguration(
            int minimumQuotas,
            int maximumQuotas,
            boolean requiresEconomicViabilityAssessment
    ) {
    }

    public record CreditConfiguration(
            BigDecimal minimumAmount,
            BigDecimal maximumAmount,
            Currency currency,
            boolean allowsMultipleCreditPlans
    ) {
    }

    public record DurationConfiguration(
            int minimumMonths,
            int maximumMonths
    ) {
    }

    public record PercentageRangeConfiguration(
            BigDecimal minimum,
            BigDecimal maximum
    ) {
    }

    public record ReserveFundConfiguration(
            boolean enabled,
            BigDecimal minimumRate,
            BigDecimal maximumRate
    ) {
    }

    public record AdjustmentConfiguration(
            String type,
            String referenceIndex
    ) {
    }

    public record AssemblyConfiguration(
            boolean allowsElectronicAssembly
    ) {
    }
}
