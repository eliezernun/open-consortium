package org.consortiumcore.group.domain;

import org.consortiumcore.shared.error.ApplicationError;

public enum GroupError implements ApplicationError {
    REQUIRED_VALUE(
            "GROUP.REQUIRED_VALUE",
            "group.required-value",
            "Required value is missing: {0}"
    ),
    INVALID_GROUP_CODE(
            "GROUP.INVALID_GROUP_CODE",
            "group.invalid-code",
            "Invalid group code: {0}"
    ),
    INVALID_GROUP_CAPACITY(
            "GROUP.INVALID_GROUP_CAPACITY",
            "group.invalid-capacity",
            "Invalid group capacity."
    ),
    INVALID_GROUP_DURATION(
            "GROUP.INVALID_GROUP_DURATION",
            "group.invalid-duration",
            "Invalid group duration."
    ),
    INVALID_GROUP_CREDIT_CONFIGURATION(
            "GROUP.INVALID_GROUP_CREDIT_CONFIGURATION",
            "group.invalid-credit-configuration",
            "Invalid group credit configuration."
    );

    private final String code;
    private final String messageKey;
    private final String defaultMessage;

    GroupError(String code, String messageKey, String defaultMessage) {
        this.code = code;
        this.messageKey = messageKey;
        this.defaultMessage = defaultMessage;
    }

    @Override
    public String code() {
        return code;
    }

    @Override
    public String messageKey() {
        return messageKey;
    }

    @Override
    public String defaultMessage() {
        return defaultMessage;
    }
}
