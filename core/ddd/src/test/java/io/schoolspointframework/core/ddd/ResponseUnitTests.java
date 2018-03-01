package io.schoolspointframework.core.ddd;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Bhuwan Prasad Upadhyay
 */
public class ResponseUnitTests {

    @Test
    public void successResponseCreateCorrectlyWithVoid() {
        assertThat(Response.success().value().isPresent()).isFalse();
    }
}