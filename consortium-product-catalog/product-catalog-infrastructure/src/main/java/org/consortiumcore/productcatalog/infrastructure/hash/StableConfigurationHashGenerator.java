package org.consortiumcore.productcatalog.infrastructure.hash;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HexFormat;
import org.consortiumcore.productcatalog.application.port.out.ConfigurationHashGenerator;
import org.consortiumcore.productcatalog.domain.definition.ProductDefinition;
import org.consortiumcore.productcatalog.domain.regulation.RegulationProfile;
import org.consortiumcore.productcatalog.domain.version.ConfigurationHash;

public final class StableConfigurationHashGenerator implements ConfigurationHashGenerator {

    @Override
    public ConfigurationHash generate(ProductDefinition definition, RegulationProfile regulationProfile) {
        String payload = definition.toString() + "|" + regulationProfile.toString();
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            return new ConfigurationHash(
                    HexFormat.of().formatHex(digest.digest(payload.getBytes(StandardCharsets.UTF_8)))
            );
        } catch (NoSuchAlgorithmException exception) {
            throw new IllegalStateException("SHA-256 algorithm is not available.", exception);
        }
    }
}
