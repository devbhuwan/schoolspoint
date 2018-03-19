package io.schoolspointframework;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Bhuwan Prasad Upadhyay
 */
@EnableStudentService
@SpringBootApplication
public class Schoolspoint {

    public static void main(String[] args) {
        SpringApplication.run(Schoolspoint.class, args);
    }

}
