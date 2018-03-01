package io.schoolspointframework.student;

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