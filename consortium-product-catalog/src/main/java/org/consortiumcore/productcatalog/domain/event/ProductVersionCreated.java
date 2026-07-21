package org.consortiumcore.productcatalog.domain.event;

import java.time.Instant;
import org.consortiumcore.productcatalog.domain.product.ProductId;
import org.consortiumcore.productcatalog.domain.version.ProductVersionId;
import org.consortiumcore.productcatalog.domain.version.VersionNumber;

public record ProductVersionCreated(
        ProductVersionId productVersionId,
        ProductId productId,
        VersionNumber versionNumber,
        Instant occurredAt
) implements DomainEvent {

    public ProductVersionCreated(ProductVersionId productVersionId, ProductId productId, VersionNumber versionNumber) {
        this(productVersionId, productId, versionNumber, Instant.now());
    }
}
