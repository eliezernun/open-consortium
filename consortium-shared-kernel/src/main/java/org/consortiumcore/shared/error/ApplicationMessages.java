package org.consortiumcore.shared.error;

public interface ApplicationMessages {

    String resolve(ApplicationError error, Object... arguments);
}
