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
@ComponentScan(basePackageClasses = RollNumberGenerator.class)
public class RollNumberGeneratorTests extends AbstractIntegrationTests {

    @Autowired
    private RollNumberGenerator rollNumberGenerator;

    @Test
    public void generateRollNumber() {
        rollNumberGenerator.newSequence(Grade.NULL);
    }
}