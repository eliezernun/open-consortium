package org.consortiumcore.productcatalog.infrastructure.regulation;

import java.time.LocalDate;
import java.util.Set;
import org.consortiumcore.productcatalog.application.port.out.RegulationProfileProvider;
import org.consortiumcore.productcatalog.domain.product.ProductTypeCode;
import org.consortiumcore.productcatalog.domain.regulation.RegulationProfile;
import org.consortiumcore.productcatalog.domain.regulation.RegulationSetId;
import org.consortiumcore.productcatalog.domain.regulation.RuleReference;

public final class FixedRegulationProfileProvider implements RegulationProfileProvider {

    @Override
    public RegulationProfile currentFor(ProductTypeCode productTypeCode, LocalDate referenceDate) {
        return new RegulationProfile(
                new RegulationSetId("DEFAULT-" + productTypeCode.value()),
                referenceDate,
                Set.of(new RuleReference("BACEN-CONSORCIO", "current", "Law 11.795/2008")),
                Set.of()
        );
    }
}
