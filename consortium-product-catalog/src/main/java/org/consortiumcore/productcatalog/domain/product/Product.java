package org.consortiumcore.productcatalog.domain.product;

import org.consortiumcore.productcatalog.domain.exception.InvalidProductStatusTransitionException;
import org.consortiumcore.productcatalog.domain.exception.ProductAlreadyRetiredException;

public final class Product {

    private final ProductId id;
    private final ProductCode code;
    private ProductName name;
    private ProductTypeCode type;
    private ProductStatus status;

    private Product(
            ProductId id,
            ProductCode code,
            ProductName name,
            ProductTypeCode type,
            ProductStatus status
    ) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.type = type;
        this.status = status;
    }

    public static Product create(
            ProductId id,
            ProductCode code,
            ProductName name,
            ProductTypeCode type
    ) {
        return new Product(
                id,
                code,
                name,
                type,
                ProductStatus.DRAFT
        );
    }

    public void activate() {
        if (status == ProductStatus.RETIRED) {
            throw new ProductAlreadyRetiredException(id);
        }

        status = ProductStatus.ACTIVE;
    }

    public void suspend() {
        if (status != ProductStatus.ACTIVE) {
            throw new InvalidProductStatusTransitionException(
                    status,
                    ProductStatus.SUSPENDED
            );
        }

        status = ProductStatus.SUSPENDED;
    }

    public void retire() {
        status = ProductStatus.RETIRED;
    }

    public boolean canReceiveNewVersion() {
        return status != ProductStatus.RETIRED;
    }

    public ProductId id() {
        return id;
    }

    public ProductCode code() {
        return code;
    }

    public ProductName name() {
        return name;
    }

    public ProductTypeCode type() {
        return type;
    }

    public ProductStatus status() {
        return status;
    }
}
