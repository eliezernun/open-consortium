package org.consortiumcore.group.domain;

public record GroupDuration(
        int minimumMonths,
        int maximumMonths
) {

    public GroupDuration {
        if (minimumMonths <= 0 || maximumMonths < minimumMonths) {
            throw new GroupDomainException(GroupError.INVALID_GROUP_DURATION);
        }
    }
}
