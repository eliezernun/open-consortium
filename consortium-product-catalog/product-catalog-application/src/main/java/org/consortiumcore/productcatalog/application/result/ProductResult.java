package org.consortiumcore.productcatalog.application.result;

import org.consortiumcore.productcatalog.domain.product.Product;
import org.consortiumcore.productcatalog.domain.product.ProductCode;
import org.consortiumcore.productcatalog.domain.product.ProductId;
import org.consortiumcore.productcatalog.domain.product.ProductName;
import org.consortiumcore.productcatalog.domain.product.ProductStatus;
import org.consortiumcore.productcatalog.domain.product.ProductTypeCode;

public record ProductResult(
        ProductId id,
        ProductCode code,
        ProductName name,
        ProductTypeCode type,
        ProductStatus status
) {

    public static ProductResult from(Product product) {
        return new ProductResult(product.id(), product.code(), product.name(), product.type(), product.status());
    }
}
