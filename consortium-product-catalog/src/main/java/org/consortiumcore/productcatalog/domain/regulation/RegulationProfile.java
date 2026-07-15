package org.consortiumcore.productcatalog.domain.regulation;

import java.time.LocalDate;
import java.util.Set;

public record RegulationProfile(
        RegulationSetId regulationSetId,
        LocalDate referenceDate,
        Set<RuleReference> mandatoryRules,
        Set<RuleReference> contractualRules
) {
}