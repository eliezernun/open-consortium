package org.consortiumcore.productcatalog.api.event;

import java.time.Instant;
import org.consortiumcore.productcatalog.domain.product.ProductId;
import org.consortiumcore.productcatalog.domain.version.ConfigurationHash;
import org.consortiumcore.productcatalog.domain.version.EffectivePeriod;
import org.consortiumcore.productcatalog.domain.version.ProductVersionId;
import org.consortiumcore.productcatalog.domain.version.VersionNumber;

public record ProductVersionPublishedEvent(
        ProductVersionId productVersionId,
        ProductId productId,
        VersionNumber versionNumber,
        EffectivePeriod effectivePeriod,
        ConfigurationHash configurationHash,
        Instant occurredAt
) {
}
