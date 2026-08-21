package org.consortiumcore.productcatalog.application.port.out;

import org.consortiumcore.productcatalog.domain.definition.ProductDefinition;
import org.consortiumcore.productcatalog.domain.regulation.RegulationProfile;
import org.consortiumcore.productcatalog.domain.version.ConfigurationHash;

public interface ConfigurationHashGenerator {

    ConfigurationHash generate(ProductDefinition definition, RegulationProfile regulationProfile);
}
