package io.schoolspointframework;

import io.schoolspointframework.student.adapters.SchoolspointChannel;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Configuration;

/**
 * @author Bhuwan Prasad Upadhyay
 */
@Configuration
@EnableBinding(SchoolspointChannel.class)
class SchoolspointStreamConfiguration {
}
