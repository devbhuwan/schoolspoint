package io.schoolspointframework.core.ddd;

import org.junit.Test;

import java.util.Optional;
import java.util.Set;

import static io.schoolspointframework.core.ddd.Response.all;
import static io.schoolspointframework.core.ddd.Response.failure;
import static io.schoolspointframework.core.ddd.ValidationError.of;
import static io.schoolspointframework.core.ddd.ValidationError.raiseIfWithMessage;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Bhuwan Prasad Upadhyay
 */
public class ResponseUnitTests {

    private static final Set<ValidationError> ERROR_SET_1 = of(raiseIfWithMessage(true, "a", "b"));
    private static final Set<ValidationError> ERROR_SET_2 =
            of(raiseIfWithMessage(true, "1", "2"),
                    raiseIfWithMessage(true, "3", "4"));

    @Test
    public void successResponseCreateCorrectlyWithVoid() {
        assertThat(Response.success().value().isPresent()).isFalse();
    }

    @Test
    public void mergeErrorsCorrectly() {
        assertThat(all(failure(Optional.empty(), ERROR_SET_1), failure(Optional.empty(), ERROR_SET_2))
                .error().validationErrors()).hasSize(3);
    }
}