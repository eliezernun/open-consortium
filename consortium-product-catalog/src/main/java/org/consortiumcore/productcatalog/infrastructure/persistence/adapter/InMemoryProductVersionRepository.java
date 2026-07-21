package org.consortiumcore.productcatalog.infrastructure.persistence.adapter;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import org.consortiumcore.productcatalog.application.port.out.ProductVersionRepository;
import org.consortiumcore.productcatalog.domain.product.ProductId;
import org.consortiumcore.productcatalog.domain.version.ProductVersion;
import org.consortiumcore.productcatalog.domain.version.ProductVersionId;
import org.consortiumcore.productcatalog.domain.version.ProductVersionStatus;

public final class InMemoryProductVersionRepository implements ProductVersionRepository {

    private final Map<ProductVersionId, ProductVersion> versions = new ConcurrentHashMap<>();

    @Override
    public void save(ProductVersion productVersion) {
        versions.put(productVersion.id(), productVersion);
    }

    @Override
    public Optional<ProductVersion> findById(ProductVersionId productVersionId) {
        return Optional.ofNullable(versions.get(productVersionId));
    }

    @Override
    public List<ProductVersion> findByProductId(ProductId productId) {
        return versions.values().stream()
                .filter(version -> version.productId().equals(productId))
                .sorted(Comparator.comparingInt(version -> version.versionNumber().value()))
                .toList();
    }

    @Override
    public Optional<ProductVersion> findEffectivePublishedVersion(ProductId productId, LocalDate referenceDate) {
        return versions.values().stream()
                .filter(version -> version.productId().equals(productId))
                .filter(version -> version.status() == ProductVersionStatus.PUBLISHED)
                .filter(version -> version.effectivePeriod().includes(referenceDate))
                .max(Comparator.comparing(version -> version.effectivePeriod().from()));
    }
}
