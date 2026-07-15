package org.consortiumcore.productcatalog.domain.definition;

import org.consortiumcore.productcatalog.domain.type.DrawMethod;
import org.consortiumcore.productcatalog.domain.type.IneligibleDrawnQuotaAction;

public record DrawDefinition(
        DrawMethod method,
        DrawSourceDefinition source,
        IneligibleDrawnQuotaAction ineligibleAction,
        int numberOfAlternates
) {
}