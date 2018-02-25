package io.schoolspointframework.core.ddd.event;

/**
 * @author Bhuwan Prasad Upadhyay
 */
@FunctionalInterface
public interface DomainEvent<T> {

    T getSource();
}
