package org.consortiumcore.productcatalog.domain.event;

import java.time.Instant;
import org.consortiumcore.productcatalog.domain.product.ProductCode;
import org.consortiumcore.productcatalog.domain.product.ProductId;
import org.consortiumcore.productcatalog.domain.product.ProductTypeCode;

public record ProductCreated(
        ProductId productId,
        ProductCode code,
        ProductTypeCode type,
        Instant occurredAt
) implements DomainEvent {

    public ProductCreated(ProductId productId, ProductCode code, ProductTypeCode type) {
        this(productId, code, type, Instant.now());
    }
}
