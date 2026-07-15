package org.consortiumcore.productcatalog.domain.definition;

import java.util.Objects;
import org.consortiumcore.productcatalog.domain.type.FormationFailureAction;

public record FormationPeriodDefinition(
        int maximumDays,
        FormationFailureAction failureAction
) {

    public FormationPeriodDefinition {
        if (maximumDays <= 0) {
            throw new IllegalArgumentException();
        }

        Objects.requireNonNull(failureAction);
    }
}