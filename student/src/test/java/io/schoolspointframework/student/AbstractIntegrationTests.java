package io.schoolspointframework.student;

import io.schoolspointframework.Schoolspoint;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Bhuwan Prasad Upadhyay
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Schoolspoint.class)
@Transactional
public abstract class AbstractIntegrationTests {
}
