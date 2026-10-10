package org.consortiumcore.group.domain;

public record GroupCapacity(
        int minimumQuotas,
        int maximumQuotas
) {

    public GroupCapacity {
        if (minimumQuotas <= 0 || maximumQuotas < minimumQuotas) {
            throw new GroupDomainException(GroupError.INVALID_GROUP_CAPACITY);
        }
    }
}
