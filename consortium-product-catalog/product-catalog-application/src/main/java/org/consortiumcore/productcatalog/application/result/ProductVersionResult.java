package org.consortiumcore.productcatalog.application.result;

import org.consortiumcore.productcatalog.domain.version.ConfigurationHash;
import org.consortiumcore.productcatalog.domain.version.EffectivePeriod;
import org.consortiumcore.productcatalog.domain.version.ProductVersion;
import org.consortiumcore.productcatalog.domain.version.ProductVersionId;
import org.consortiumcore.productcatalog.domain.version.ProductVersionStatus;
import org.consortiumcore.productcatalog.domain.version.VersionNumber;

public record ProductVersionResult(
        ProductVersionId id,
        VersionNumber versionNumber,
        ProductVersionStatus status,
        EffectivePeriod effectivePeriod,
        ConfigurationHash configurationHash
) {

    public static ProductVersionResult from(ProductVersion productVersion) {
        return new ProductVersionResult(
                productVersion.id(),
                productVersion.versionNumber(),
                productVersion.status(),
                productVersion.effectivePeriod(),
                productVersion.configurationHash()
        );
    }
}
