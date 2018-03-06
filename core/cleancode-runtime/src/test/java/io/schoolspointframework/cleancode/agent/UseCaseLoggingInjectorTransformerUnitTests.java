package io.schoolspointframework.cleancode.agent;

import io.schoolspointframework.core.cleancode.usecase.UseCase;
import org.junit.jupiter.api.Test;

import static org.apache.commons.lang3.StringUtils.EMPTY;

/**
 * @author Bhuwan Prasad Upadhyay
 */
class UseCaseLoggingInjectorTransformerUnitTests {

    private static final String INPUT = "INPUT";

    @Test
    void correctlyLoggedBeforeUseCaseCode() {
        new SimpleUseCase().execute(INPUT);
    }

    class SimpleUseCase implements UseCase<String, String> {

        @Override
        public String execute(String model) {
            return EMPTY;
        }
    }
}