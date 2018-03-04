package io.schoolspointframework.student.domain;


import org.junit.jupiter.api.Test;

import static org.apache.commons.lang3.StringUtils.EMPTY;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Bhuwan Prasad Upadhyay
 */
class GradeUnitTests {

    @Test
    void defaultsToNurseryAsGradeAndEmptyGroup() {
        assertThat(Grade.create(null, null).value()).isEqualTo(Grade.create(GradeType.NURSERY, EMPTY).value());
    }
}