package io.schoolspointframework.student.adapters;

import io.schoolspointframework.student.model.StudentProtos.ApplicantRegisteredPayload;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;
import org.springframework.messaging.support.MessageBuilder;

import java.util.Optional;

/**
 * @author Bhuwan Prasad Upadhyay
 */
public interface SchoolspointChannel extends Source, Sink {

    @Output(Source.OUTPUT)
    MessageChannel output();

    @Output(Sink.INPUT)
    SubscribableChannel input();

    default Optional<Void> send(ApplicantRegisteredPayload payload) {
        output().send(MessageBuilder.withPayload(payload).build());
        return Optional.empty();
    }

}
