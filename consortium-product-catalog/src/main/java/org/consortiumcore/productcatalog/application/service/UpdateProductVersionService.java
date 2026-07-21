package org.consortiumcore.productcatalog.application.service;

import org.consortiumcore.productcatalog.application.command.UpdateProductVersionCommand;
import org.consortiumcore.productcatalog.application.exception.ProductVersionNotFoundException;
import org.consortiumcore.productcatalog.application.port.in.UpdateProductVersionUseCase;
import org.consortiumcore.productcatalog.application.port.out.ProductVersionRepository;
import org.consortiumcore.productcatalog.application.result.ProductVersionResult;
import org.consortiumcore.productcatalog.domain.version.ProductVersion;

public final class UpdateProductVersionService implements UpdateProductVersionUseCase {

    private final ProductVersionRepository productVersionRepository;

    public UpdateProductVersionService(ProductVersionRepository productVersionRepository) {
        this.productVersionRepository = productVersionRepository;
    }

    @Override
    public ProductVersionResult updateVersion(UpdateProductVersionCommand command) {
        ProductVersion productVersion = productVersionRepository.findById(command.productVersionId())
                .orElseThrow(() -> new ProductVersionNotFoundException(command.productVersionId()));
        productVersion.changeDefinition(command.definition());
        productVersionRepository.save(productVersion);
        return ProductVersionResult.from(productVersion);
    }
}
