package org.consortiumcore.productcatalog.domain.type;

import org.consortiumcore.productcatalog.domain.definition.ProductDefinition;
import org.consortiumcore.productcatalog.domain.error.Required;
import org.consortiumcore.productcatalog.domain.product.ProductTypeCode;

public interface ProductType {

    ProductTypeCode code();

    default void validate(ProductDefinition definition) {
        Required.notNull(definition, "definition");
    }
}
