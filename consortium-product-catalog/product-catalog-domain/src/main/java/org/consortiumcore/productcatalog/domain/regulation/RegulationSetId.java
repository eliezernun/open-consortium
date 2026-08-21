package org.consortiumcore.productcatalog.domain.regulation;

import org.consortiumcore.productcatalog.domain.error.ProductCatalogError;
import org.consortiumcore.productcatalog.domain.error.Required;
import org.consortiumcore.productcatalog.domain.exception.ProductCatalogValidationException;

public record RegulationSetId(String value) {

    public RegulationSetId {
        Required.notNull(value, "regulationSetId");
        value = value.trim();
        if (value.isBlank()) {
            throw new ProductCatalogValidationException(ProductCatalogError.INVALID_REGULATION_SET_ID);
        }
    }
}
