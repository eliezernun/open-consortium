package org.consortiumcore.productcatalog.domain.definition;

import org.consortiumcore.productcatalog.domain.type.AdministrationFeeCalculationBasis;
import org.consortiumcore.productcatalog.domain.type.AdministrationFeeCollectionMode;

public record AdministrationFeeDefinition(
        PercentageRange allowedRate,
        AdministrationFeeCollectionMode collectionMode,
        AdministrationFeeCalculationBasis calculationBasis
) {
}