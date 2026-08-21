package org.consortiumcore.productcatalog.domain.product;

import java.util.Locale;
import java.util.Objects;
import java.util.regex.Pattern;
import org.consortiumcore.productcatalog.domain.error.ProductCatalogError;
import org.consortiumcore.productcatalog.domain.exception.InvalidProductCodeException;
import org.consortiumcore.productcatalog.domain.exception.ProductCatalogValidationException;

public record ProductCode(String value) {

    private static final Pattern PATTERN =
            Pattern.compile("^[A-Z][A-Z0-9_-]{2,39}$");

    public ProductCode {
        if (value == null) {
            throw new ProductCatalogValidationException(ProductCatalogError.REQUIRED_VALUE, "productCode");
        }

        String normalized = value.trim().toUpperCase(Locale.ROOT);

        if (!PATTERN.matcher(normalized).matches()) {
            throw new InvalidProductCodeException(value);
        }

        value = normalized;
    }
}
