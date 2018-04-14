package io.schoolspointframework.lang.ddd.event;

import io.schoolspointframework.lang.ddd.event.DomainEvent;
import org.springframework.context.ApplicationEvent;

/**
 * @author Bhuwan Prasad Upadhyay
 */
public abstract class ApplicationDomainEvent<T> extends ApplicationEvent implements DomainEvent<T> {

    private final T _source;

    public ApplicationDomainEvent(T e) {
        super(e);
        this._source = e;
    }

    @Override
    public T getSource() {
        return _source;
    }
}
