package org.consortiumcore.productcatalog.domain.regulation;

public record RuleReference(
        String ruleId,
        String version,
        String legalBasis
) {
}