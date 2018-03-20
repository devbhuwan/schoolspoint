package io.schoolspointframework;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Bhuwan Prasad Upadhyay
 */
@SpringBootApplication
@EnableServicePersistence
@EnableServiceStreams
@EnableServiceEndpoints
public class Schoolspoint {

    public static void main(String[] args) {
        SpringApplication.run(Schoolspoint.class, args);
    }

}
