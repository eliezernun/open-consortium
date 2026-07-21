package org.consortiumcore.productcatalog.application.port.in;

import java.time.LocalDate;
import org.consortiumcore.productcatalog.domain.product.ProductId;
import org.consortiumcore.productcatalog.domain.version.PublishedProductVersion;

public interface ObtainPublishedProductVersionUseCase {

    PublishedProductVersion obtain(ProductId productId, LocalDate referenceDate);
}
