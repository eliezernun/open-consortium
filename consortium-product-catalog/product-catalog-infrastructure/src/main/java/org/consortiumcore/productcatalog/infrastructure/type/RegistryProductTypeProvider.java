package org.consortiumcore.productcatalog.infrastructure.type;

import org.consortiumcore.productcatalog.application.port.out.ProductTypeProvider;
import org.consortiumcore.productcatalog.domain.product.ProductTypeCode;
import org.consortiumcore.productcatalog.domain.type.ProductType;
import org.consortiumcore.productcatalog.domain.type.ProductTypeRegistry;

public final class RegistryProductTypeProvider implements ProductTypeProvider {

    private final ProductTypeRegistry registry;

    public RegistryProductTypeProvider(ProductTypeRegistry registry) {
        this.registry = registry;
    }

    public RegistryProductTypeProvider() {
        this(new ProductTypeRegistry());
    }

    @Override
    public ProductType get(ProductTypeCode code) {
        return registry.get(code);
    }
}
