package io.schoolspointframework.core.jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author Bhuwan Prasad Upadhyay
 */
@SpringBootApplication
@ComponentScan(basePackageClasses = DddRuntimeTestApp.class)
public class DddRuntimeTestApp {

    public static void main(String[] args) {

        SpringApplication.run(DddRuntimeTestApp.class, args);
    }

}
