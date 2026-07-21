package org.consortiumcore.productcatalog.domain.definition;

import org.consortiumcore.productcatalog.domain.error.ProductCatalogError;
import org.consortiumcore.productcatalog.domain.error.Required;
import org.consortiumcore.productcatalog.domain.exception.ProductCatalogValidationException;

public record DrawSourceDefinition(
        String sourceCode,
        boolean requiresExternalEvidence
) {

    public DrawSourceDefinition {
        Required.notNull(sourceCode, "drawSource.sourceCode");
        sourceCode = sourceCode.trim().toUpperCase();
        if (sourceCode.isBlank()) {
            throw new ProductCatalogValidationException(ProductCatalogError.INVALID_DRAW_SOURCE);
        }
    }
}
