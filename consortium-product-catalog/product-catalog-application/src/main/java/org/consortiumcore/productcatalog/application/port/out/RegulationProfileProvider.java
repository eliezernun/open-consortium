package org.consortiumcore.productcatalog.application.port.out;

import java.time.LocalDate;
import org.consortiumcore.productcatalog.domain.product.ProductTypeCode;
import org.consortiumcore.productcatalog.domain.regulation.RegulationProfile;

public interface RegulationProfileProvider {

    RegulationProfile currentFor(ProductTypeCode productTypeCode, LocalDate referenceDate);
}
