package org.consortiumcore.productcatalog.domain.definition;

import org.consortiumcore.productcatalog.domain.type.AssemblyProcessingOrder;

public record AssemblyDefinition(
        AssemblyFrequency frequency,
        int minimumDaysBetweenAssemblies,
        boolean allowsElectronicAssembly,
        AssemblyProcessingOrder processingOrder,
        EligibilityDefinition eligibility
) {
}