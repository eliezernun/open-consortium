package org.consortiumcore.productcatalog.domain.version;

public record VersionNumber(int value) {

    public VersionNumber {
        if (value <= 0) {
            throw new IllegalArgumentException(
                    "Número da versão deve ser maior que zero."
            );
        }
    }

    public VersionNumber next() {
        return new VersionNumber(value + 1);
    }
}