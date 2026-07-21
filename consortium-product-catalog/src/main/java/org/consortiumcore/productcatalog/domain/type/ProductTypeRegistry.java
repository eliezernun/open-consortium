package org.consortiumcore.productcatalog.domain.type;

import java.util.Map;
import org.consortiumcore.productcatalog.domain.error.ProductCatalogError;
import org.consortiumcore.productcatalog.domain.exception.ProductCatalogValidationException;
import org.consortiumcore.productcatalog.domain.product.ProductTypeCode;

public final class ProductTypeRegistry {

    private final Map<ProductTypeCode, ProductType> productTypes;

    public ProductTypeRegistry() {
        this(Map.of(
                ProductTypeCode.MOVABLE_GOODS, new MovableGoodsProductType(),
                ProductTypeCode.REAL_ESTATE, new RealEstateProductType(),
                ProductTypeCode.SERVICES, new ServicesProductType()
        ));
    }

    public ProductTypeRegistry(Map<ProductTypeCode, ProductType> productTypes) {
        this.productTypes = Map.copyOf(productTypes);
    }

    public ProductType get(ProductTypeCode code) {
        ProductType productType = productTypes.get(code);
        if (productType == null) {
            throw new ProductCatalogValidationException(ProductCatalogError.PRODUCT_TYPE_NOT_REGISTERED, code.value());
        }
        return productType;
    }
}
