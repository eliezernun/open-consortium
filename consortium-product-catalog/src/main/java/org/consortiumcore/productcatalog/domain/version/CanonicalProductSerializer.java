package org.consortiumcore.productcatalog.domain.version;

import java.nio.charset.StandardCharsets;
import org.consortiumcore.productcatalog.domain.definition.ProductDefinition;
import org.consortiumcore.productcatalog.domain.regulation.RegulationProfile;

final class CanonicalProductSerializer {

    private CanonicalProductSerializer() {
    }

    static byte[] serialize(ProductDefinition definition, RegulationProfile regulation) {
        String canonical = definition.toString() + "|" + regulation.toString();
        return canonical.getBytes(StandardCharsets.UTF_8);
    }
}
