package io.schoolspointframework.lang.ddd.event;

/**
 * @author Bhuwan Prasad Upadhyay
 */
@FunctionalInterface
public interface DomainEvent<T> {

    T getSource();
}
