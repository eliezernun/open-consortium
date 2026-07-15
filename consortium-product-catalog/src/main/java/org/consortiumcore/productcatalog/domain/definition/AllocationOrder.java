package org.consortiumcore.productcatalog.domain.definition;

import org.consortiumcore.productcatalog.domain.type.ContributionComponentType;

import java.util.List;
import java.util.Objects;

public record AllocationOrder(
        List<ContributionComponentType> components
) {

    public AllocationOrder {
        Objects.requireNonNull(components);

        if (components.isEmpty()) {
            throw new InvalidAllocationOrderException();
        }

        components = List.copyOf(components);
    }
}