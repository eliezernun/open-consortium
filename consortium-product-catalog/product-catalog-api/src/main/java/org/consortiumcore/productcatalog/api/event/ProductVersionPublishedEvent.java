package org.consortiumcore.productcatalog.api.event;

import java.time.Instant;
import java.time.LocalDate;
import java.util.UUID;

public record ProductVersionPublishedEvent(
        UUID productVersionId,
        UUID productId,
        int versionNumber,
        LocalDate effectiveFrom,
        LocalDate effectiveUntil,
        String configurationHash,
        Instant occurredAt
) {
}
