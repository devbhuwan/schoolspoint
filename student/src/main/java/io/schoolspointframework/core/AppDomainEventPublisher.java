package io.schoolspointframework.core;

import io.schoolspointframework.lang.ddd.event.DomainEvent;
import io.schoolspointframework.lang.ddd.event.DomainEventPublisher;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * @author Bhuwan Prasad Upadhyay
 */
@Component
@Slf4j
public class AppDomainEventPublisher implements DomainEventPublisher {

    private final ApplicationEventPublisher publisher;

    public AppDomainEventPublisher(ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }

    @Override
    public <T> Optional<Void> publish(DomainEvent<T> event) {
        LOG.info("Before Publish [{}]", event.getClass().getName());
        publisher.publishEvent((ApplicationEvent) event);
        LOG.info("After Published [{}]", event.getClass().getName());
        return Optional.empty();
    }
}
