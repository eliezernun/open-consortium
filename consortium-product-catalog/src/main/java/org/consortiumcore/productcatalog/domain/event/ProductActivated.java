package org.consortiumcore.productcatalog.domain.event;

import java.time.Instant;
import org.consortiumcore.productcatalog.domain.product.ProductId;

public record ProductActivated(
        ProductId productId,
        Instant occurredAt
) implements DomainEvent {

    public ProductActivated(ProductId productId) {
        this(productId, Instant.now());
    }
}
