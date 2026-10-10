package org.consortiumcore.group.domain;

import org.consortiumcore.shared.error.ApplicationError;
import org.consortiumcore.shared.error.ApplicationException;

public class GroupDomainException extends ApplicationException {

    public GroupDomainException(ApplicationError error, Object... arguments) {
        super(error, arguments);
    }
}
