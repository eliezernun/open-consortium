package org.consortiumcore.productcatalog.api;

import java.time.LocalDate;
import java.util.UUID;

public record PublishedProductVersion(
        UUID productId,
        UUID productVersionId,
        String productCode,
        String productType,
        int versionNumber,
        LocalDate effectiveFrom,
        LocalDate effectiveUntil,
        ProductConfigurationSnapshot configuration,
        String configurationHash
) {
}
