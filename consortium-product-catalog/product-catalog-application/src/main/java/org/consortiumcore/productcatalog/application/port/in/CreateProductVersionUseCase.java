package org.consortiumcore.productcatalog.application.port.in;

import org.consortiumcore.productcatalog.application.command.CreateProductVersionCommand;
import org.consortiumcore.productcatalog.application.result.ProductVersionResult;

public interface CreateProductVersionUseCase {

    ProductVersionResult createVersion(CreateProductVersionCommand command);
}
