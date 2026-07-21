package org.consortiumcore.productcatalog.domain.version;

import org.consortiumcore.productcatalog.domain.definition.ProductDefinition;
import org.consortiumcore.productcatalog.domain.error.Required;
import org.consortiumcore.productcatalog.domain.regulation.RegulationProfile;

public record ProductConfigurationSnapshot(
        ProductDefinition definition,
        RegulationProfile regulationProfile
) {

    public ProductConfigurationSnapshot {
        Required.notNull(definition, "definition");
        Required.notNull(regulationProfile, "regulationProfile");
    }
}
