package org.consortiumcore.productcatalog.domain.version;

import org.consortiumcore.productcatalog.domain.error.ProductCatalogError;
import org.consortiumcore.productcatalog.domain.exception.ProductCatalogValidationException;

public record VersionNumber(int value) {

    public VersionNumber {
        if (value <= 0) {
            throw new ProductCatalogValidationException(ProductCatalogError.INVALID_VERSION_NUMBER);
        }
    }

    public VersionNumber next() {
        return new VersionNumber(value + 1);
    }
}
