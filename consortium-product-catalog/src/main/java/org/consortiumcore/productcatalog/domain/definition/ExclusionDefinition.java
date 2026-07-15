package org.consortiumcore.productcatalog.domain.definition;

import java.util.Set;
import org.consortiumcore.productcatalog.domain.type.ExclusionReason;

public record ExclusionDefinition(
        Set<ExclusionReason> allowedReasons,
        int maximumOverdueInstallments,
        ExclusionNotificationDefinition notification,
        RestitutionDefinition restitution
) {
}