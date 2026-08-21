package org.consortiumcore.productcatalog.domain.version;

import org.consortiumcore.productcatalog.domain.error.Required;
import org.consortiumcore.productcatalog.domain.error.ProductCatalogError;
import org.consortiumcore.productcatalog.domain.exception.ProductCatalogValidationException;

public record ConfigurationHash(String value) {

    public ConfigurationHash {
        Required.notNull(value, "configurationHash");
        value = value.trim();
        if (value.isBlank()) {
            throw new ProductCatalogValidationException(ProductCatalogError.REQUIRED_VALUE, "configurationHash");
        }
    }
}
