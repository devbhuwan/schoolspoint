package io.schoolspointframework.student.domain;

import io.schoolspointframework.student.AbstractIntegrationTests;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author Bhuwan Prasad Upadhyay
 */
@DataJpaTest
@ComponentScan(basePackageClasses = StudentManager.class)
public class StudentManagerTests extends AbstractIntegrationTests {

    @Autowired
    private StudentManager<Student> studentManager;

    @Test(expected = IllegalArgumentException.class)
    public void nullAddTest() {
        studentManager.save(null);
    }
}