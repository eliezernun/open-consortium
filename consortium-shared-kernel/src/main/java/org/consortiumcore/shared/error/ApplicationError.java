package org.consortiumcore.shared.error;

public interface ApplicationError {

    String code();

    String messageKey();

    String defaultMessage();
}
