package io.schoolspointframework.core;

import io.schoolspointframework.lang.ddd.event.DomainEvent;
import io.schoolspointframework.lang.ddd.event.DomainEventPublisher;
import org.springframework.stereotype.Component;

/**
 * @author Bhuwan Prasad Upadhyay
 */
@Component
public class AppDomainEventPublisher implements DomainEventPublisher {

    @Override
    public <T> void publish(DomainEvent<T> event) {

    }
}
