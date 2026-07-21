package org.consortiumcore.productcatalog.domain.regulation;

import java.time.LocalDate;
import java.util.Set;
import org.consortiumcore.productcatalog.domain.error.Required;

public record RegulationProfile(
        RegulationSetId regulationSetId,
        LocalDate referenceDate,
        Set<RuleReference> mandatoryRules,
        Set<RuleReference> contractualRules
) {
    public RegulationProfile {
        Required.notNull(regulationSetId, "regulationSetId");
        Required.notNull(referenceDate, "referenceDate");
        mandatoryRules = mandatoryRules == null ? Set.of() : Set.copyOf(mandatoryRules);
        contractualRules = contractualRules == null ? Set.of() : Set.copyOf(contractualRules);
    }
}
