package io.schoolspointframework.core;

import io.schoolspointframework.lang.ddd.event.DomainEvent;
import io.schoolspointframework.lang.ddd.event.DomainEventPublisher;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * @author Bhuwan Prasad Upadhyay
 */
@Component
public class AppDomainEventPublisher implements DomainEventPublisher {

    @Override
    public <T> Optional<Void> publish(DomainEvent<T> event) {

        return Optional.empty();
    }
}
