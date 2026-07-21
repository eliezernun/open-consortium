package org.consortiumcore.productcatalog.domain.version;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.consortiumcore.productcatalog.domain.error.ProductCatalogError;
import org.consortiumcore.productcatalog.domain.exception.ProductCatalogValidationException;

final class Sha256 {

    private Sha256() {
    }

    static String hashHex(byte[] bytes) {
        try {
            byte[] digest = MessageDigest.getInstance("SHA-256").digest(bytes);
            StringBuilder builder = new StringBuilder(digest.length * 2);
            for (byte value : digest) {
                builder.append(String.format("%02x", value));
            }
            return builder.toString();
        } catch (NoSuchAlgorithmException exception) {
            throw new ProductCatalogValidationException(ProductCatalogError.INVALID_CONFIGURATION_HASH_ALGORITHM);
        }
    }
}
