package io.schoolspointframework.lang.ddd;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Bhuwan Prasad Upadhyay
 */
class ResponseUnitTests {

    @Test
    void successResponseCreateCorrectlyWithVoid() {
        assertThat(Response.success().value().isPresent()).isFalse();
    }

}