package org.consortiumcore.productcatalog.domain.definition;

public record DurationDefinition(
        MonthRange groupDuration,
        MonthRange quotaPaymentDuration
) {
}