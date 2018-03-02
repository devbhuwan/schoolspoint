package io.schoolspointframework.core;

import io.schoolspointframework.core.ddd.event.DomainEvent;
import io.schoolspointframework.core.ddd.event.DomainEventPublisher;
import org.springframework.stereotype.Component;

/**
 * @author Bhuwan Prasad Upadhyay
 */
@Component
public class KafkaDomainEventPublisher implements DomainEventPublisher {

    @Override
    public <T> void publish(DomainEvent<T> event) {

    }

}
