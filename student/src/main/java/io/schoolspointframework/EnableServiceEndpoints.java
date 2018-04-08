package io.schoolspointframework;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.http.converter.protobuf.ProtobufHttpMessageConverter;

import java.lang.annotation.*;

/**
 * @author Bhuwan Prasad Upadhyay
 */
@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface EnableServiceEndpoints {

    @Configuration
    class HttpMessageConverterConfiguration {

        @Bean
        @Primary
        ProtobufHttpMessageConverter protobufHttpMessageConverter() {
            return new ProtobufHttpMessageConverter();
        }

    }
}
