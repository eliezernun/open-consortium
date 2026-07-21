package org.consortiumcore.productcatalog.domain.type;

import org.consortiumcore.productcatalog.domain.definition.ProductDefinition;
import org.consortiumcore.productcatalog.domain.error.ProductCatalogError;
import org.consortiumcore.productcatalog.domain.exception.ProductCatalogValidationException;
import org.consortiumcore.productcatalog.domain.product.ProductTypeCode;

public final class ServicesProductType implements ProductType {

    @Override
    public ProductTypeCode code() {
        return ProductTypeCode.SERVICES;
    }

    @Override
    public void validate(ProductDefinition definition) {
        if (!definition.credit().utilization().allowedTypes().contains(CreditUtilizationType.SERVICE)) {
            throw new ProductCatalogValidationException(ProductCatalogError.INVALID_PRODUCT_TYPE_DEFINITION, code().value());
        }
    }
}
