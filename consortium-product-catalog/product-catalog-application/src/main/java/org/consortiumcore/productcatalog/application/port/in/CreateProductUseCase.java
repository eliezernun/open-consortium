package org.consortiumcore.productcatalog.application.port.in;

import org.consortiumcore.productcatalog.application.command.CreateProductCommand;
import org.consortiumcore.productcatalog.application.result.ProductResult;

public interface CreateProductUseCase {

    ProductResult create(CreateProductCommand command);
}
