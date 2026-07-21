package org.consortiumcore.productcatalog.domain.event;

import java.time.Instant;
import org.consortiumcore.productcatalog.domain.product.ProductId;
import org.consortiumcore.productcatalog.domain.version.ConfigurationHash;
import org.consortiumcore.productcatalog.domain.version.EffectivePeriod;
import org.consortiumcore.productcatalog.domain.version.ProductVersionId;
import org.consortiumcore.productcatalog.domain.version.VersionNumber;

public record ProductVersionPublished(
        ProductVersionId productVersionId,
        ProductId productId,
        VersionNumber versionNumber,
        EffectivePeriod effectivePeriod,
        ConfigurationHash configurationHash,
        Instant occurredAt
) implements DomainEvent {

    public ProductVersionPublished(
            ProductVersionId productVersionId,
            ProductId productId,
            VersionNumber versionNumber,
            EffectivePeriod effectivePeriod,
            ConfigurationHash configurationHash
    ) {
        this(productVersionId, productId, versionNumber, effectivePeriod, configurationHash, Instant.now());
    }
}
