package org.consortiumcore.productcatalog.application.port.in;

import org.consortiumcore.productcatalog.application.command.PublishProductVersionCommand;
import org.consortiumcore.productcatalog.application.result.ProductVersionResult;

public interface PublishProductVersionUseCase {

    ProductVersionResult publish(PublishProductVersionCommand command);
}
