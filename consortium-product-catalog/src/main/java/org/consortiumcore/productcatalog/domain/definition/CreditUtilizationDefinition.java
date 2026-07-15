package org.consortiumcore.productcatalog.domain.definition;

import java.util.Set;
import org.consortiumcore.productcatalog.domain.type.CreditUtilizationType;

public record CreditUtilizationDefinition(
        Set<CreditUtilizationType> allowedTypes,
        boolean allowsDebtSettlement,
        boolean allowsOwnAssetAcquisition
) {
}