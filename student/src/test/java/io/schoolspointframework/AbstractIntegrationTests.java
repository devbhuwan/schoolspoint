package io.schoolspointframework;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 * @author Bhuwan Prasad Upadhyay
 */
@ExtendWith(SpringExtension.class)
@ComponentScan(basePackageClasses = Schoolspoint.class)
public abstract class AbstractIntegrationTests {
}
