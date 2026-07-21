package org.consortiumcore.productcatalog.domain.definition;

import org.consortiumcore.productcatalog.domain.error.ProductCatalogError;
import org.consortiumcore.productcatalog.domain.exception.ProductCatalogValidationException;

public record BidSubmissionDefinition(
        int deadlineHoursBeforeAssembly,
        boolean allowsElectronicSubmission,
        boolean requiresAvailableFundsProof
) {

    public BidSubmissionDefinition {
        if (deadlineHoursBeforeAssembly < 0) {
            throw new ProductCatalogValidationException(ProductCatalogError.INVALID_BID_SUBMISSION_DEADLINE);
        }
    }
}
