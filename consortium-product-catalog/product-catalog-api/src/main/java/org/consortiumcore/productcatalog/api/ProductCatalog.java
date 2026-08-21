package org.consortiumcore.productcatalog.api;

import java.time.LocalDate;

public interface ProductCatalog {

    PublishedProductVersion obtainPublishedVersion(
            ProductVersionReference reference,
            LocalDate referenceDate
    );
}
