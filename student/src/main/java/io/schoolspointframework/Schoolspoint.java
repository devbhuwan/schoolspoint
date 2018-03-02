package io.schoolspointframework;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author Bhuwan Prasad Upadhyay
 */
@SpringBootApplication
public class Schoolspoint {
    public static void main(String[] args) {
        SpringApplication.run(Schoolspoint.class, args);
    }
}
