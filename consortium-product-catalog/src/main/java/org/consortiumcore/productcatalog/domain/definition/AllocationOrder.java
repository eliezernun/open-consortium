package org.consortiumcore.productcatalog.domain.definition;

import org.consortiumcore.productcatalog.domain.type.ContributionComponentType;

import java.util.List;
import org.consortiumcore.productcatalog.domain.error.Required;
import org.consortiumcore.productcatalog.domain.exception.InvalidAllocationOrderException;

public record AllocationOrder(
        List<ContributionComponentType> components
) {

    public AllocationOrder {
        Required.notNull(components, "allocationOrder.components");

        if (components.isEmpty()) {
            throw new InvalidAllocationOrderException();
        }

        components = List.copyOf(components);
    }
}
