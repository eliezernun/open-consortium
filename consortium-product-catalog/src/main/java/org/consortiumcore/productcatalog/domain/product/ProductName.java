package org.consortiumcore.productcatalog.domain.product;

import java.util.Objects;

public record ProductName(String value) {

    public ProductName {
        Objects.requireNonNull(value, "Nome do produto é obrigatório.");

        String normalized = value.trim();

        if (normalized.length() < 3 || normalized.length() > 150) {
            throw new InvalidProductNameException(value);
        }

        value = normalized;
    }
}