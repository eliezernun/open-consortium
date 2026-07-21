package org.consortiumcore.productcatalog.application.command;

import org.consortiumcore.productcatalog.domain.product.ProductId;

public record ActivateProductCommand(ProductId productId) {
}
