package io.schoolspointframework.student.adapters;

import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.cloud.stream.messaging.Source;

/**
 * @author Bhuwan Prasad Upadhyay
 */
interface SchoolspointStreams extends Source, Sink {
}
