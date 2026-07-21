package org.consortiumcore.productcatalog.application.port.in;

import org.consortiumcore.productcatalog.application.command.UpdateProductVersionCommand;
import org.consortiumcore.productcatalog.application.result.ProductVersionResult;

public interface UpdateProductVersionUseCase {

    ProductVersionResult updateVersion(UpdateProductVersionCommand command);
}
