package io.schoolspointframework;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.lang.annotation.*;

/**
 * @author Bhuwan Prasad Upadhyay
 */
@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@EntityScan
@interface EnableServicePersistence {

}
