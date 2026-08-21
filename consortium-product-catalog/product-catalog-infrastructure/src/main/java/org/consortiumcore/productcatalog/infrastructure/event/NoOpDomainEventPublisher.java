package org.consortiumcore.productcatalog.infrastructure.event;

import java.util.Collection;
import org.consortiumcore.productcatalog.application.port.out.DomainEventPublisher;
import org.consortiumcore.productcatalog.domain.event.DomainEvent;

public final class NoOpDomainEventPublisher implements DomainEventPublisher {

    @Override
    public void publish(Collection<DomainEvent> events) {
        // Intentional adapter for composition without a broker or event bus.
    }
}
