package org.consortiumcore.productcatalog.application.command;

import org.consortiumcore.productcatalog.domain.definition.ProductDefinition;
import org.consortiumcore.productcatalog.domain.version.ProductVersionId;

public record UpdateProductVersionCommand(
        ProductVersionId productVersionId,
        ProductDefinition definition
) {
}
