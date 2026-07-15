package org.consortiumcore.productcatalog.domain.version;

import java.util.List;
import java.util.Objects;
import org.consortiumcore.productcatalog.domain.definition.ProductDefinition;
import org.consortiumcore.productcatalog.domain.product.ProductId;
import org.consortiumcore.productcatalog.domain.regulation.RegulationProfile;

import org.consortiumcore.productcatalog.domain.version.ProductVersionStatus;

import java.util.ArrayList;

public final class ProductVersion {

    private final ProductVersionId id;
    private final ProductId productId;
    private final VersionNumber versionNumber;

    private ProductVersionStatus status;
    private EffectivePeriod effectivePeriod;
    private ProductDefinition definition;
    private RegulationProfile regulationProfile;
    private ConfigurationHash configurationHash;

    private final List<DomainEvent> domainEvents;

    private ProductVersion(
            ProductVersionId id,
            ProductId productId,
            VersionNumber versionNumber,
            ProductDefinition definition,
            RegulationProfile regulationProfile
    ) {
        this.id = id;
        this.productId = productId;
        this.versionNumber = versionNumber;
        this.definition = definition;
        this.regulationProfile = regulationProfile;
        this.status = ProductVersionStatus.DRAFT;
        this.domainEvents = new ArrayList<>();
    }

    public static ProductVersion create(
            ProductVersionId id,
            ProductId productId,
            VersionNumber versionNumber,
            ProductDefinition definition,
            RegulationProfile regulationProfile
    ) {
        return new ProductVersion(
                id,
                productId,
                versionNumber,
                definition,
                regulationProfile
        );
    }

    public void publish(
            EffectivePeriod effectivePeriod,
            ProductType productType,
            ProductVersionValidator validator
    ) {
        ensureDraft();

        validator.validate(definition, regulationProfile);
        productType.validate(definition);

        this.effectivePeriod = effectivePeriod;
        this.configurationHash =
                ConfigurationHash.calculate(definition, regulationProfile);

        this.status = ProductVersionStatus.PUBLISHED;

        domainEvents.add(
                new ProductVersionPublished(
                        id,
                        productId,
                        versionNumber,
                        effectivePeriod,
                        configurationHash
                )
        );
    }

    public void changeDefinition(ProductDefinition newDefinition) {
        ensureDraft();
        this.definition = Objects.requireNonNull(newDefinition);
    }

    private void ensureDraft() {
        if (status != ProductVersionStatus.DRAFT) {
            throw new PublishedProductVersionCannotBeModifiedException(id);
        }
    }
}