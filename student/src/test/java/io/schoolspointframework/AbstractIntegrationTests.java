package io.schoolspointframework;

import org.junit.runner.RunWith;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author Bhuwan Prasad Upadhyay
 */
@RunWith(SpringRunner.class)
@ComponentScan(basePackageClasses = Schoolspoint.class)
public abstract class AbstractIntegrationTests {
}
