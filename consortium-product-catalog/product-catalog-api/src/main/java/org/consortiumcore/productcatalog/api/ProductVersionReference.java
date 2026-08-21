package org.consortiumcore.productcatalog.api;

import java.util.UUID;

public record ProductVersionReference(
        UUID productId,
        UUID productVersionId
) {
}
