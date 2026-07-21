package org.consortiumcore.productcatalog.application.port.in;

import org.consortiumcore.productcatalog.application.command.ActivateProductCommand;
import org.consortiumcore.productcatalog.application.result.ProductResult;

public interface ActivateProductUseCase {

    ProductResult activate(ActivateProductCommand command);
}
