package org.consortiumcore.productcatalog.application.port.out;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import org.consortiumcore.productcatalog.domain.product.ProductId;
import org.consortiumcore.productcatalog.domain.version.ProductVersion;
import org.consortiumcore.productcatalog.domain.version.ProductVersionId;
import org.consortiumcore.productcatalog.domain.version.ProductVersionStatus;

public interface ProductVersionRepository {

    void save(ProductVersion productVersion);

    Optional<ProductVersion> findById(ProductVersionId productVersionId);

    List<ProductVersion> findByProductId(ProductId productId);

    Optional<ProductVersion> findEffectivePublishedVersion(ProductId productId, LocalDate referenceDate);

    default List<ProductVersion> findPublishedByProductId(ProductId productId) {
        return findByProductId(productId).stream()
                .filter(version -> version.status() == ProductVersionStatus.PUBLISHED)
                .toList();
    }
}
