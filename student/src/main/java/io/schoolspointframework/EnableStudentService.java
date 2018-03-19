package io.schoolspointframework;

import io.schoolspointframework.EnableStudentService.SchoolspointSecurityAutoConfiguration;
import io.schoolspointframework.EnableStudentService.SchoolspointStreamAutoConfiguration;
import io.schoolspointframework.EnableStudentService.SchoolspointWebAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author Bhuwan Prasad Upadhyay
 */
@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import({
        SchoolspointWebAutoConfiguration.class,
        SchoolspointSecurityAutoConfiguration.class,
        SchoolspointStreamAutoConfiguration.class
})
@EntityScan
@SpringBootApplication
public @interface EnableStudentService {

    @Configuration
    @ConditionalOnMissingBean(SchoolspointWebConfiguration.class)
    @Import(SchoolspointWebConfiguration.class)
    class SchoolspointWebAutoConfiguration {
    }

    @Configuration
    @ConditionalOnMissingBean(SchoolspointSecurityConfiguration.class)
    @Import(SchoolspointSecurityConfiguration.class)
    class SchoolspointSecurityAutoConfiguration {
    }

    @Configuration
    @ConditionalOnMissingBean(SchoolspointStreamConfiguration.class)
    @Import(SchoolspointStreamConfiguration.class)
    class SchoolspointStreamAutoConfiguration {
    }

}
