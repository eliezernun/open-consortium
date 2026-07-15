package org.consortiumcore.productcatalog.domain.version;

import java.util.Objects;
import java.util.UUID;

public record ProductVersionId(UUID value) {

    public ProductVersionId {
        Objects.requireNonNull(value);
    }

    public static ProductVersionId generate() {
        return new ProductVersionId(UUID.randomUUID());
    }
}