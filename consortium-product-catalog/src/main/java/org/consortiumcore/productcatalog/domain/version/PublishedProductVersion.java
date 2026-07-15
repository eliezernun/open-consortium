package org.consortiumcore.productcatalog.domain.version;

import org.consortiumcore.productcatalog.domain.product.ProductCode;
import org.consortiumcore.productcatalog.domain.product.ProductId;
import org.consortiumcore.productcatalog.domain.product.ProductTypeCode;

public record PublishedProductVersion(
        ProductId productId,
        ProductVersionId productVersionId,
        ProductCode productCode,
        ProductTypeCode productType,
        VersionNumber versionNumber,
        EffectivePeriod effectivePeriod,
        ProductConfigurationSnapshot configuration,
        ConfigurationHash configurationHash
) {
}