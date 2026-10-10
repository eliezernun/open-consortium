package org.consortiumcore.productcatalog.infrastructure.configuration;

import org.consortiumcore.productcatalog.api.ProductCatalog;

public record ProductCatalogRuntime(
        ProductCatalog catalog,
        ProductCatalogUseCases useCases
) {
}
