package org.consortiumcore.productcatalog.application.port.out;

import org.consortiumcore.productcatalog.domain.product.ProductTypeCode;
import org.consortiumcore.productcatalog.domain.type.ProductType;

public interface ProductTypeProvider {

    ProductType get(ProductTypeCode code);
}
