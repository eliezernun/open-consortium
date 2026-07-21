package org.consortiumcore.productcatalog.domain.definition;

import org.consortiumcore.productcatalog.domain.error.ProductCatalogError;
import org.consortiumcore.productcatalog.domain.exception.ProductCatalogValidationException;

public record EligibilityCutoffDefinition(
        int daysBeforeAssembly,
        boolean includesAssemblyDatePayments
) {

    public EligibilityCutoffDefinition {
        if (daysBeforeAssembly < 0) {
            throw new ProductCatalogValidationException(ProductCatalogError.INVALID_ELIGIBILITY_CUTOFF);
        }
    }
}
