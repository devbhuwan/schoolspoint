package io.schoolspointframework.student.domain;

import io.schoolspointframework.student.AbstractIntegrationTests;
import io.schoolspointframework.student.domain.Student;
import io.schoolspointframework.student.domain.StudentManager;
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