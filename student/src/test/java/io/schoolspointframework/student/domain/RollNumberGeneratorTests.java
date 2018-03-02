package io.schoolspointframework.student.domain;

import io.schoolspointframework.student.AbstractIntegrationTests;
import io.schoolspointframework.student.domain.RollNumberGenerator;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Bhuwan Prasad Upadhyay
 */
public class RollNumberGeneratorTests extends AbstractIntegrationTests {

    @Autowired
    private RollNumberGenerator rollNumberGenerator;

    @Test
    public void generateRollNumber() {
        rollNumberGenerator.newSequence(Grade.NULL);
    }
}