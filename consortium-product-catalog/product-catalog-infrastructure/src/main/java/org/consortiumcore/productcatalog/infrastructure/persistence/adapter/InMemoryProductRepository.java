package org.consortiumcore.productcatalog.infrastructure.persistence.adapter;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import org.consortiumcore.productcatalog.application.port.out.ProductRepository;
import org.consortiumcore.productcatalog.domain.product.Product;
import org.consortiumcore.productcatalog.domain.product.ProductCode;
import org.consortiumcore.productcatalog.domain.product.ProductId;

public final class InMemoryProductRepository implements ProductRepository {

    private final Map<ProductId, Product> products = new ConcurrentHashMap<>();

    @Override
    public void save(Product product) {
        products.put(product.id(), product);
    }

    @Override
    public Optional<Product> findById(ProductId productId) {
        return Optional.ofNullable(products.get(productId));
    }

    @Override
    public Optional<Product> findByCode(ProductCode code) {
        return products.values().stream()
                .filter(product -> product.code().equals(code))
                .findFirst();
    }
}
