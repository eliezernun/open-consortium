package org.consortiumcore.productcatalog.application.port.out;

import java.util.Optional;
import org.consortiumcore.productcatalog.domain.product.Product;
import org.consortiumcore.productcatalog.domain.product.ProductCode;
import org.consortiumcore.productcatalog.domain.product.ProductId;

public interface ProductRepository {

    void save(Product product);

    Optional<Product> findById(ProductId productId);

    Optional<Product> findByCode(ProductCode code);
}
