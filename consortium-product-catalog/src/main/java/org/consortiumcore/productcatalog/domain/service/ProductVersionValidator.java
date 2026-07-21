package org.consortiumcore.productcatalog.domain.service;

import org.consortiumcore.productcatalog.domain.definition.ProductDefinition;
import org.consortiumcore.productcatalog.domain.error.ProductCatalogError;
import org.consortiumcore.productcatalog.domain.exception.ProductCatalogValidationException;
import org.consortiumcore.productcatalog.domain.regulation.RegulationProfile;

public final class ProductVersionValidator {

    public void validate(ProductDefinition definition, RegulationProfile regulationProfile) {
        if (definition.reserveFund() == null) {
            throw new ProductCatalogValidationException(
                    ProductCatalogError.INVALID_PRODUCT_VERSION_DEFINITION,
                    "reserve fund is required"
            );
        }
        if (definition.duration().quotaPaymentDuration().maximum() > definition.duration().groupDuration().maximum()) {
            throw new ProductCatalogValidationException(
                    ProductCatalogError.INVALID_PRODUCT_VERSION_DEFINITION,
                    "quota payment duration cannot exceed group duration"
            );
        }
        if (regulationProfile.mandatoryRules().isEmpty()) {
            throw new ProductCatalogValidationException(
                    ProductCatalogError.INVALID_PRODUCT_VERSION_DEFINITION,
                    "regulation profile must define mandatory rules"
            );
        }
    }
}
