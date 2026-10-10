package org.consortiumcore.group.domain;

import java.time.LocalDate;
import java.util.UUID;
import org.consortiumcore.productcatalog.api.PublishedProductVersion;
import org.consortiumcore.shared.error.Required;

public record GroupConfigurationSnapshot(
        UUID productId,
        UUID productVersionId,
        String productCode,
        String productType,
        int productVersionNumber,
        LocalDate productEffectiveFrom,
        LocalDate productEffectiveUntil,
        String productConfigurationHash,
        GroupCapacity capacity,
        GroupDuration duration,
        GroupCreditConfiguration credit,
        boolean requiresEconomicViabilityAssessment
) {

    public GroupConfigurationSnapshot {
        Required.notNull(productId, GroupError.REQUIRED_VALUE, "productId");
        Required.notNull(productVersionId, GroupError.REQUIRED_VALUE, "productVersionId");
        Required.notNull(productCode, GroupError.REQUIRED_VALUE, "productCode");
        Required.notNull(productType, GroupError.REQUIRED_VALUE, "productType");
        Required.notNull(productEffectiveFrom, GroupError.REQUIRED_VALUE, "productEffectiveFrom");
        Required.notNull(productConfigurationHash, GroupError.REQUIRED_VALUE, "productConfigurationHash");
        Required.notNull(capacity, GroupError.REQUIRED_VALUE, "groupCapacity");
        Required.notNull(duration, GroupError.REQUIRED_VALUE, "groupDuration");
        Required.notNull(credit, GroupError.REQUIRED_VALUE, "groupCredit");
    }

    public static GroupConfigurationSnapshot from(PublishedProductVersion version) {
        Required.notNull(version, GroupError.REQUIRED_VALUE, "publishedProductVersion");
        return new GroupConfigurationSnapshot(
                version.productId(),
                version.productVersionId(),
                version.productCode(),
                version.productType(),
                version.versionNumber(),
                version.effectiveFrom(),
                version.effectiveUntil(),
                version.configurationHash(),
                new GroupCapacity(
                        version.configuration().group().minimumQuotas(),
                        version.configuration().group().maximumQuotas()
                ),
                new GroupDuration(
                        version.configuration().duration().minimumMonths(),
                        version.configuration().duration().maximumMonths()
                ),
                new GroupCreditConfiguration(
                        version.configuration().credit().minimumAmount(),
                        version.configuration().credit().maximumAmount(),
                        version.configuration().credit().currency(),
                        version.configuration().credit().allowsMultipleCreditPlans()
                ),
                version.configuration().group().requiresEconomicViabilityAssessment()
        );
    }
}
