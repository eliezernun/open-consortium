package org.consortiumcore.productcatalog.application.service;

import java.util.List;
import org.consortiumcore.productcatalog.application.command.CreateProductCommand;
import org.consortiumcore.productcatalog.application.port.in.CreateProductUseCase;
import org.consortiumcore.productcatalog.application.port.out.DomainEventPublisher;
import org.consortiumcore.productcatalog.application.port.out.ProductRepository;
import org.consortiumcore.productcatalog.application.result.ProductResult;
import org.consortiumcore.productcatalog.domain.error.ProductCatalogError;
import org.consortiumcore.productcatalog.domain.event.ProductCreated;
import org.consortiumcore.productcatalog.domain.exception.ProductCatalogValidationException;
import org.consortiumcore.productcatalog.domain.product.Product;
import org.consortiumcore.productcatalog.domain.product.ProductId;

public final class CreateProductService implements CreateProductUseCase {

    private final ProductRepository productRepository;
    private final DomainEventPublisher eventPublisher;

    public CreateProductService(ProductRepository productRepository, DomainEventPublisher eventPublisher) {
        this.productRepository = productRepository;
        this.eventPublisher = eventPublisher;
    }

    @Override
    public ProductResult create(CreateProductCommand command) {
        productRepository.findByCode(command.code()).ifPresent(existing -> {
            throw new ProductCatalogValidationException(ProductCatalogError.DUPLICATED_PRODUCT_CODE, existing.code().value());
        });

        Product product = Product.create(ProductId.generate(), command.code(), command.name(), command.type());
        productRepository.save(product);
        eventPublisher.publish(List.of(new ProductCreated(product.id(), product.code(), product.type())));
        return ProductResult.from(product);
    }
}
