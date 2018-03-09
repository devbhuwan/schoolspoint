package io.schoolspointframework.lang.ddd.event;

import java.util.Optional;

/**
 * @author Bhuwan Prasad Upadhyay
 */
@FunctionalInterface
public interface DomainEventPublisher {

    <T> Optional<Void> publish(DomainEvent<T> event);
}
