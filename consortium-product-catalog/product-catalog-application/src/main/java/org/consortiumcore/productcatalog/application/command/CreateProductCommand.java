package org.consortiumcore.productcatalog.application.command;

import org.consortiumcore.productcatalog.domain.product.ProductCode;
import org.consortiumcore.productcatalog.domain.product.ProductName;
import org.consortiumcore.productcatalog.domain.product.ProductTypeCode;

public record CreateProductCommand(
        ProductCode code,
        ProductName name,
        ProductTypeCode type
) {
}
