package org.consortiumcore.productcatalog.domain.version;

import java.util.ArrayList;
import java.util.List;
import org.consortiumcore.productcatalog.domain.definition.ProductDefinition;
import org.consortiumcore.productcatalog.domain.error.Required;
import org.consortiumcore.productcatalog.domain.event.DomainEvent;
import org.consortiumcore.productcatalog.domain.event.ProductVersionPublished;
import org.consortiumcore.productcatalog.domain.exception.PublishedProductVersionCannotBeModifiedException;
import org.consortiumcore.productcatalog.domain.product.ProductId;
import org.consortiumcore.productcatalog.domain.regulation.RegulationProfile;
import org.consortiumcore.productcatalog.domain.service.ProductVersionValidator;
import org.consortiumcore.productcatalog.domain.type.ProductType;

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
            ConfigurationHash configurationHash,
            ProductType productType,
            ProductVersionValidator validator
    ) {
        ensureUnderReview();

        validator.validate(definition, regulationProfile);
        productType.validate(definition);

        this.effectivePeriod = effectivePeriod;
        this.configurationHash = Required.notNull(configurationHash, "configurationHash");

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

    public void submitForReview() {
        ensureDraft();
        status = ProductVersionStatus.UNDER_REVIEW;
    }

    public void suspend() {
        if (status != ProductVersionStatus.PUBLISHED) {
            throw new PublishedProductVersionCannotBeModifiedException(id);
        }
        status = ProductVersionStatus.SUSPENDED;
    }

    public void reactivate() {
        if (status != ProductVersionStatus.SUSPENDED) {
            throw new PublishedProductVersionCannotBeModifiedException(id);
        }
        status = ProductVersionStatus.PUBLISHED;
    }

    public void retire() {
        if (status != ProductVersionStatus.PUBLISHED && status != ProductVersionStatus.SUSPENDED) {
            throw new PublishedProductVersionCannotBeModifiedException(id);
        }
        status = ProductVersionStatus.RETIRED;
    }

    public void changeDefinition(ProductDefinition newDefinition) {
        ensureDraft();
        this.definition = Required.notNull(newDefinition, "definition");
    }

    private void ensureDraft() {
        if (status != ProductVersionStatus.DRAFT) {
            throw new PublishedProductVersionCannotBeModifiedException(id);
        }
    }

    private void ensureUnderReview() {
        if (status != ProductVersionStatus.UNDER_REVIEW) {
            throw new PublishedProductVersionCannotBeModifiedException(id);
        }
    }

    public List<DomainEvent> pullDomainEvents() {
        List<DomainEvent> events = List.copyOf(domainEvents);
        domainEvents.clear();
        return events;
    }

    public ProductVersionId id() {
        return id;
    }

    public ProductId productId() {
        return productId;
    }

    public VersionNumber versionNumber() {
        return versionNumber;
    }

    public ProductVersionStatus status() {
        return status;
    }

    public EffectivePeriod effectivePeriod() {
        return effectivePeriod;
    }

    public ProductDefinition definition() {
        return definition;
    }

    public RegulationProfile regulationProfile() {
        return regulationProfile;
    }

    public ConfigurationHash configurationHash() {
        return configurationHash;
    }
}
