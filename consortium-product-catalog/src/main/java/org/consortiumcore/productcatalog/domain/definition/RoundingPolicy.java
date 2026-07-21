package org.consortiumcore.productcatalog.domain.definition;

import java.math.RoundingMode;
import org.consortiumcore.productcatalog.domain.error.ProductCatalogError;
import org.consortiumcore.productcatalog.domain.error.Required;
import org.consortiumcore.productcatalog.domain.exception.ProductCatalogValidationException;

public record RoundingPolicy(int scale, RoundingMode mode) {

    public RoundingPolicy {
        if (scale < 0) {
            throw new ProductCatalogValidationException(ProductCatalogError.INVALID_ROUNDING_POLICY);
        }
        Required.notNull(mode, "roundingPolicy.mode");
    }

    public static RoundingPolicy money() {
        return new RoundingPolicy(2, RoundingMode.HALF_UP);
    }
}
