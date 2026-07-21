package org.consortiumcore.productcatalog.domain.definition;

public record RestitutionDefinition(
        boolean required,
        boolean appliesContractualDeductions,
        ReferenceIndexCode correctionIndex
) {
}
