package org.consortiumcore.productcatalog.api.event;

import java.time.Instant;
import java.util.UUID;

public record ProductVersionRetiredEvent(
        UUID productVersionId,
        UUID productId,
        Instant occurredAt
) {
}
