package org.consortiumcore.productcatalog.domain.error;

public final class Required {

    private Required() {
    }

    public static <T> T notNull(T value, String fieldName) {
        return org.consortiumcore.shared.error.Required.notNull(
                value,
                ProductCatalogError.REQUIRED_VALUE,
                fieldName
        );
    }
}
