package org.consortiumcore.productcatalog.domain.definition;

import org.consortiumcore.productcatalog.domain.type.TransferFinancialTreatment;

public record TransferDefinition(
        boolean allowed,
        boolean allowedBeforeContemplation,
        boolean allowedAfterContemplation,
        boolean requiresApproval,
        TransferFinancialTreatment financialTreatment
) {
}