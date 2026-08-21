package org.consortiumcore.productcatalog.domain.product;

import java.util.Locale;
import org.consortiumcore.productcatalog.domain.error.Required;

public record ProductTypeCode(String value) {

    public static final ProductTypeCode MOVABLE_GOODS =
            new ProductTypeCode("MOVABLE_GOODS");

    public static final ProductTypeCode REAL_ESTATE =
            new ProductTypeCode("REAL_ESTATE");

    public static final ProductTypeCode SERVICES =
            new ProductTypeCode("SERVICES");

    public ProductTypeCode {
        Required.notNull(value, "productTypeCode");
        value = value.trim().toUpperCase(Locale.ROOT);
    }
}
