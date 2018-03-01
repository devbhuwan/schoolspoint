package io.schoolspointframework.student;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Bhuwan Prasad Upadhyay
 */
public class StudentManagerTests extends AbstractIntegrationTests {

    @Autowired
    private StudentManager<Student> studentManager;

    @Test(expected = IllegalArgumentException.class)
    public void nullAddTest() {
        studentManager.save(null);
    }
}