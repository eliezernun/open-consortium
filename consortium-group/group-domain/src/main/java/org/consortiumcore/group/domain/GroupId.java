package org.consortiumcore.group.domain;

import java.util.UUID;
import org.consortiumcore.shared.error.Required;

public record GroupId(UUID value) {

    public GroupId {
        Required.notNull(value, GroupError.REQUIRED_VALUE, "groupId");
    }

    public static GroupId generate() {
        return new GroupId(UUID.randomUUID());
    }
}
