package org.consortiumcore.productcatalog.application.command;

import org.consortiumcore.productcatalog.domain.version.EffectivePeriod;
import org.consortiumcore.productcatalog.domain.version.ProductVersionId;

public record PublishProductVersionCommand(
        ProductVersionId productVersionId,
        EffectivePeriod effectivePeriod
) {
}
