package io.schoolspointframework.core.ddd.event;

/**
 * @author Bhuwan Prasad Upadhyay
 */
@FunctionalInterface
public interface DomainEventPublisher {

    <T> void publish(DomainEvent<T> event);
}
