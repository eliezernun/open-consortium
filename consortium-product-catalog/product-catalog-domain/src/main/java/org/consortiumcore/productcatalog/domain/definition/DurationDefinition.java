package org.consortiumcore.productcatalog.domain.definition;

import org.consortiumcore.productcatalog.domain.error.Required;

public record DurationDefinition(
        MonthRange allowedDuration
) {

    public DurationDefinition {
        Required.notNull(allowedDuration, "duration.allowedDuration");
    }
}
