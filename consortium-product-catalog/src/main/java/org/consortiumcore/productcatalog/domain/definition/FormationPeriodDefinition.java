package org.consortiumcore.productcatalog.domain.definition;

import org.consortiumcore.productcatalog.domain.error.ProductCatalogError;
import org.consortiumcore.productcatalog.domain.error.Required;
import org.consortiumcore.productcatalog.domain.exception.ProductCatalogValidationException;
import org.consortiumcore.productcatalog.domain.type.FormationFailureAction;

public record FormationPeriodDefinition(
        int maximumDays,
        FormationFailureAction failureAction
) {

    public FormationPeriodDefinition {
        if (maximumDays <= 0) {
            throw new ProductCatalogValidationException(ProductCatalogError.INVALID_FORMATION_PERIOD);
        }

        Required.notNull(failureAction, "formationPeriod.failureAction");
    }
}
