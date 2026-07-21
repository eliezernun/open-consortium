package org.consortiumcore.productcatalog.domain.event;

import java.time.Instant;

public interface DomainEvent {

    Instant occurredAt();
}
