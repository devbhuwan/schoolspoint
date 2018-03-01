package io.schoolspointframework.student;

import org.junit.Test;

import static org.apache.commons.lang3.StringUtils.EMPTY;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author Bhuwan Prasad Upadhyay
 */
public class GradeUnitTests {

    @Test
    public void defaultsToNurseryAsGradeAndEmptyGroup() {
        assertThat(Grade.create(null, null), is(Grade.create(GradeType.NURSERY, EMPTY)));
    }
}