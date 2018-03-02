package io.schoolspointframework.student.domain;

import io.schoolspointframework.student.AbstractIntegrationTests;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

/**
 * @author Bhuwan Prasad Upadhyay
 */
@DataJpaTest
public class StudentManagerIntegrationTests extends AbstractIntegrationTests {

    @Autowired
    private StudentManager<Student> studentManager;

    @Test(expected = IllegalArgumentException.class)
    public void nullAddTest() {
        studentManager.save(null);
    }
}