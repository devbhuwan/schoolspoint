package io.schoolspointframework.student.domain;

import io.schoolspointframework.Schoolspoint;
import io.schoolspointframework.SchoolspointExtension;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author Bhuwan Prasad Upadhyay
 */
@SpringBootTest(classes = Schoolspoint.class)
@ExtendWith(SchoolspointExtension.class)
class StudentManagerIntegrationTests {

    @Autowired
    private StudentManager<Student> studentManager;

    @Test
    void nullAddTest() {
        Assertions.assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> studentManager.save(null));
    }
}