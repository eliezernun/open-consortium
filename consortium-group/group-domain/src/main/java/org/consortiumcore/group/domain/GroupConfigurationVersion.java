package org.consortiumcore.group.domain;

public record GroupConfigurationVersion(int value) {

    public GroupConfigurationVersion {
        if (value <= 0) {
            throw new GroupDomainException(GroupError.REQUIRED_VALUE, "groupConfigurationVersion");
        }
    }

    public static GroupConfigurationVersion initial() {
        return new GroupConfigurationVersion(1);
    }
}
