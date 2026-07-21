package org.consortiumcore.shared.error;

public class ApplicationException extends RuntimeException {

    private final ApplicationError error;

    public ApplicationException(ApplicationError error, Object... arguments) {
        super(ApplicationMessageResolver.resolve(error, arguments));
        this.error = error;
    }

    public ApplicationError error() {
        return error;
    }

    public String code() {
        return error.code();
    }

    public String messageKey() {
        return error.messageKey();
    }
}
