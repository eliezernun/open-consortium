package org.consortiumcore.productcatalog.domain.definition;

import org.consortiumcore.productcatalog.domain.error.ProductCatalogError;
import org.consortiumcore.productcatalog.domain.exception.ProductCatalogValidationException;

public record ExclusionNotificationDefinition(
        int daysBeforeExclusion,
        boolean requiresFormalNotice
) {

    public ExclusionNotificationDefinition {
        if (daysBeforeExclusion < 0) {
            throw new ProductCatalogValidationException(ProductCatalogError.INVALID_EXCLUSION_NOTIFICATION_PERIOD);
        }
    }
}
