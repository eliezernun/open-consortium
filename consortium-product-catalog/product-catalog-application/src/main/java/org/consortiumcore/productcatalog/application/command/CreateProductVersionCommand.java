package org.consortiumcore.productcatalog.application.command;

import java.time.LocalDate;
import org.consortiumcore.productcatalog.domain.definition.ProductDefinition;
import org.consortiumcore.productcatalog.domain.product.ProductId;

public record CreateProductVersionCommand(
        ProductId productId,
        ProductDefinition definition,
        LocalDate regulationReferenceDate
) {
}
