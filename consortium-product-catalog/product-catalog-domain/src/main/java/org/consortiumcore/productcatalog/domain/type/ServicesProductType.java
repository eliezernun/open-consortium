package org.consortiumcore.productcatalog.domain.type;

import org.consortiumcore.productcatalog.domain.definition.ProductDefinition;
import org.consortiumcore.productcatalog.domain.product.ProductTypeCode;

public final class ServicesProductType implements ProductType {

    @Override
    public ProductTypeCode code() {
        return ProductTypeCode.SERVICES;
    }

    @Override
    public void validate(ProductDefinition definition) {
        ProductType.super.validate(definition);
    }
}
