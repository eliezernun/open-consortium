package org.consortiumcore.productcatalog.domain.product;

import java.util.Objects;
import org.consortiumcore.productcatalog.domain.error.ProductCatalogError;
import org.consortiumcore.productcatalog.domain.exception.InvalidProductNameException;
import org.consortiumcore.productcatalog.domain.exception.ProductCatalogValidationException;

public record ProductName(String value) {

    public ProductName {
        if (value == null) {
            throw new ProductCatalogValidationException(ProductCatalogError.REQUIRED_VALUE, "productName");
        }

        String normalized = value.trim();

        if (normalized.length() < 3 || normalized.length() > 150) {
            throw new InvalidProductNameException(value);
        }

        value = normalized;
    }
}
