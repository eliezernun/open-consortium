package org.consortiumcore.group.domain;

import org.consortiumcore.productcatalog.api.PublishedProductVersion;
import org.consortiumcore.shared.error.Required;

public final class ConsortiumGroup {

    private final GroupId id;
    private final GroupCode code;
    private final GroupConfigurationVersion configurationVersion;
    private final GroupConfigurationSnapshot configuration;
    private GroupStatus status;

    private ConsortiumGroup(
            GroupId id,
            GroupCode code,
            GroupConfigurationVersion configurationVersion,
            GroupConfigurationSnapshot configuration
    ) {
        this.id = Required.notNull(id, GroupError.REQUIRED_VALUE, "groupId");
        this.code = Required.notNull(code, GroupError.REQUIRED_VALUE, "groupCode");
        this.configurationVersion = Required.notNull(
                configurationVersion,
                GroupError.REQUIRED_VALUE,
                "groupConfigurationVersion"
        );
        this.configuration = Required.notNull(configuration, GroupError.REQUIRED_VALUE, "groupConfiguration");
        this.status = GroupStatus.DRAFT;
    }

    public static ConsortiumGroup create(
            GroupId id,
            GroupCode code,
            PublishedProductVersion productVersion
    ) {
        return new ConsortiumGroup(
                id,
                code,
                GroupConfigurationVersion.initial(),
                GroupConfigurationSnapshot.from(productVersion)
        );
    }

    public GroupId id() {
        return id;
    }

    public GroupCode code() {
        return code;
    }

    public GroupConfigurationVersion configurationVersion() {
        return configurationVersion;
    }

    public GroupConfigurationSnapshot configuration() {
        return configuration;
    }

    public GroupStatus status() {
        return status;
    }
}
