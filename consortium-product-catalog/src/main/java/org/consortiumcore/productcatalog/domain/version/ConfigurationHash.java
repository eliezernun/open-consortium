package org.consortiumcore.productcatalog.domain.version;

import org.consortiumcore.productcatalog.domain.definition.ProductDefinition;
import org.consortiumcore.productcatalog.domain.regulation.RegulationProfile;

public record ConfigurationHash(String value) {

    public static ConfigurationHash calculate(
            ProductDefinition definition,
            RegulationProfile regulation
    ) {
        byte[] canonicalBytes =
                CanonicalProductSerializer.serialize(
                        definition,
                        regulation
                );

        return new ConfigurationHash(
                Sha256.hashHex(canonicalBytes)
        );
    }
}