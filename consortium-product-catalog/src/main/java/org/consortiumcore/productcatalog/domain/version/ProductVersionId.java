package org.consortiumcore.productcatalog.domain.version;

import java.util.UUID;
import org.consortiumcore.productcatalog.domain.error.Required;

public record ProductVersionId(UUID value) {

    public ProductVersionId {
        Required.notNull(value, "productVersionId");
    }

    public static ProductVersionId generate() {
        return new ProductVersionId(UUID.randomUUID());
    }
}
