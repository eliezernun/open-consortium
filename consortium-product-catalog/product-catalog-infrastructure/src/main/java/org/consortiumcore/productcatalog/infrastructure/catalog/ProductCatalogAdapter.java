package org.consortiumcore.productcatalog.infrastructure.catalog;

import java.time.LocalDate;
import org.consortiumcore.productcatalog.api.ProductCatalog;
import org.consortiumcore.productcatalog.application.port.in.ObtainPublishedProductVersionUseCase;
import org.consortiumcore.productcatalog.api.ProductVersionReference;
import org.consortiumcore.productcatalog.api.PublishedProductVersion;

public final class ProductCatalogAdapter implements ProductCatalog {

    private final ObtainPublishedProductVersionUseCase obtainPublishedProductVersionUseCase;

    public ProductCatalogAdapter(
            ObtainPublishedProductVersionUseCase obtainPublishedProductVersionUseCase
    ) {
        this.obtainPublishedProductVersionUseCase = obtainPublishedProductVersionUseCase;
    }

    @Override
    public PublishedProductVersion obtainPublishedVersion(
            ProductVersionReference reference,
            LocalDate referenceDate
    ) {
        return obtainPublishedProductVersionUseCase.obtain(reference, referenceDate);
    }
}
