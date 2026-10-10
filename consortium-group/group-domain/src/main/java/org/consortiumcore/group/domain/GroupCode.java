package org.consortiumcore.group.domain;

import java.util.Locale;
import java.util.regex.Pattern;
import org.consortiumcore.shared.error.Required;

public record GroupCode(String value) {

    private static final Pattern PATTERN = Pattern.compile("^[A-Z][A-Z0-9_-]{2,39}$");

    public GroupCode {
        Required.notNull(value, GroupError.REQUIRED_VALUE, "groupCode");
        value = value.trim().toUpperCase(Locale.ROOT);
        if (!PATTERN.matcher(value).matches()) {
            throw new GroupDomainException(GroupError.INVALID_GROUP_CODE, value);
        }
    }
}
