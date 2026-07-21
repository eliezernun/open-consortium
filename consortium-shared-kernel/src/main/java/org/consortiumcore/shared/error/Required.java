package org.consortiumcore.shared.error;

public final class Required {

    private Required() {
    }

    public static <T> T notNull(T value, ApplicationError error, String fieldName) {
        if (value == null) {
            throw new ApplicationException(error, fieldName);
        }
        return value;
    }
}
