package io.schoolspointframework;

import io.schoolspointframework.student.adapters.StudentServiceStreams;
import org.springframework.cloud.stream.annotation.EnableBinding;

import java.lang.annotation.*;

/**
 * @author Bhuwan Prasad Upadhyay
 */
@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@EnableBinding(StudentServiceStreams.class)
@interface EnableServiceStreams {

}
