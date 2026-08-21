package org.consortiumcore.productcatalog.application.port.in;

import java.time.LocalDate;
import org.consortiumcore.productcatalog.api.ProductVersionReference;
import org.consortiumcore.productcatalog.api.PublishedProductVersion;

public interface ObtainPublishedProductVersionUseCase {

    PublishedProductVersion obtain(ProductVersionReference reference, LocalDate referenceDate);
}
