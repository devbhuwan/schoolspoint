package io.schoolspointframework;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author Bhuwan Prasad Upadhyay
 */
@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import({SchoolspointWebAutoConfiguration.class, SchoolspointSecurityAutoConfiguration.class})
@EntityScan
@SpringBootApplication
@interface EnableStudentService {
}
