package org.consortiumcore.productcatalog.domain.product;

import java.util.Objects;
import java.util.UUID;
import org.consortiumcore.productcatalog.domain.error.ProductCatalogError;
import org.consortiumcore.productcatalog.domain.exception.ProductCatalogValidationException;

public record ProductId(UUID value) {

    public ProductId {
        if (value == null) {
            throw new ProductCatalogValidationException(ProductCatalogError.REQUIRED_VALUE, "productId");
        }
    }

    public static ProductId generate() {
        return new ProductId(UUID.randomUUID());
    }
}
