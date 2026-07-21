package org.consortiumcore.productcatalog.api.event;

import java.time.Instant;
import org.consortiumcore.productcatalog.domain.product.ProductId;
import org.consortiumcore.productcatalog.domain.version.ProductVersionId;

public record ProductVersionRetiredEvent(
        ProductVersionId productVersionId,
        ProductId productId,
        Instant occurredAt
) {
}
