package io.schoolspointframework.core;

import io.schoolspointframework.lang.ddd.event.DomainEvent;
import org.springframework.context.ApplicationEvent;

/**
 * @author Bhuwan Prasad Upadhyay
 */
public class ApplicationDomainEvent<T> extends ApplicationEvent implements DomainEvent<T> {

    private final T _source;

    private ApplicationDomainEvent(T source) {
        super(source);
        this._source = source;
    }

    public static <E> ApplicationDomainEvent<E> createEvent(E e) {
        return new ApplicationDomainEvent<>(e);
    }

    @Override
    public T getSource() {
        return _source;
    }
}
