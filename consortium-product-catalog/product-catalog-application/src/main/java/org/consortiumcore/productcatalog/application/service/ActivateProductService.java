package org.consortiumcore.productcatalog.application.service;

import java.util.List;
import org.consortiumcore.productcatalog.application.command.ActivateProductCommand;
import org.consortiumcore.productcatalog.application.exception.ProductNotFoundException;
import org.consortiumcore.productcatalog.application.port.in.ActivateProductUseCase;
import org.consortiumcore.productcatalog.application.port.out.DomainEventPublisher;
import org.consortiumcore.productcatalog.application.port.out.ProductRepository;
import org.consortiumcore.productcatalog.application.result.ProductResult;
import org.consortiumcore.productcatalog.domain.event.ProductActivated;
import org.consortiumcore.productcatalog.domain.product.Product;

public final class ActivateProductService implements ActivateProductUseCase {

    private final ProductRepository productRepository;
    private final DomainEventPublisher eventPublisher;

    public ActivateProductService(ProductRepository productRepository, DomainEventPublisher eventPublisher) {
        this.productRepository = productRepository;
        this.eventPublisher = eventPublisher;
    }

    @Override
    public ProductResult activate(ActivateProductCommand command) {
        Product product = productRepository.findById(command.productId())
                .orElseThrow(() -> new ProductNotFoundException(command.productId()));
        product.activate();
        productRepository.save(product);
        eventPublisher.publish(List.of(new ProductActivated(product.id())));
        return ProductResult.from(product);
    }
}
