package io.schoolspointframework.student.usecase;

import io.schoolspointframework.student.AbstractIntegrationTests;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

/**
 * @author Bhuwan Prasad Upadhyay
 */
@DataJpaTest
public class RegisterApplicantUseCaseTests extends AbstractIntegrationTests {

    @Autowired
    private RegisterApplicantUseCase registerApplicantUseCase;

    @Test
    public void name() {

    }
}