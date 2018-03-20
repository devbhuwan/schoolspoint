package io.schoolspointframework.student.adapters;

import io.schoolspointframework.student.model.StudentProtos.ApplicantRegisteredPayload;
import org.springframework.messaging.support.MessageBuilder;

import java.util.Optional;

public interface StudentServiceStreams extends SchoolspointStreams {

    default Optional<Void> send(ApplicantRegisteredPayload payload) {
        output().send(MessageBuilder.withPayload(payload).build());
        return Optional.empty();
    }

}
