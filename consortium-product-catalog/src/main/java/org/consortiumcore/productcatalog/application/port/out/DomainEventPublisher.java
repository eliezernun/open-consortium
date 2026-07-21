package org.consortiumcore.productcatalog.application.port.out;

import java.util.Collection;
import org.consortiumcore.productcatalog.domain.event.DomainEvent;

public interface DomainEventPublisher {

    void publish(Collection<DomainEvent> events);
}
