package org.consortiumcore.productcatalog.api;

import org.consortiumcore.productcatalog.domain.product.ProductId;
import org.consortiumcore.productcatalog.domain.version.ProductVersionId;
import org.consortiumcore.productcatalog.domain.version.VersionNumber;

public record ProductVersionReference(
        ProductId productId,
        ProductVersionId productVersionId,
        VersionNumber versionNumber
) {
}
