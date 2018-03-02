package io.schoolspointframework.student.domain;

import org.junit.Test;

import static io.netty.util.internal.StringUtil.SPACE;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Bhuwan Prasad Upadhyay
 */
public class NameUnitTests {
    private static final String LAST_NAME = "UPADHYAY";
    private static final String MIDDLE_NAME = "UPADHYAY";
    private static final String FIRST_NAME = "BHUWAN";
    private static final String BLANK_FIRST_NAME = "   ";
    private static final String BLANK_LAST_NAME = "";

    @Test
    public void rejectsNullAndBlankFirstName() {
        assertThat(Name.create(null, MIDDLE_NAME, LAST_NAME).error().validationErrors())
                .extracting("causedBy").contains("firstName");
        assertThat(Name.create(BLANK_FIRST_NAME, MIDDLE_NAME, LAST_NAME).error().validationErrors())
                .extracting("causedBy").contains("firstName");
    }

    @Test
    public void rejectsNullAndBlankLastName() {
        assertThat(Name.create(FIRST_NAME, MIDDLE_NAME, null).error().validationErrors())
                .extracting("causedBy").contains("lastName");
        assertThat(Name.create(FIRST_NAME, MIDDLE_NAME, BLANK_LAST_NAME).error().validationErrors())
                .extracting("causedBy").contains("lastName");
    }

    @Test
    public void printsFullNameToString() {
        assertThat(Name.create(FIRST_NAME, MIDDLE_NAME, LAST_NAME).value().toString())
                .isEqualTo(FIRST_NAME + SPACE + MIDDLE_NAME + SPACE + LAST_NAME);
    }

    @Test
    public void equalsTwoNameByFullName() {
        Name name1 = Name.create(FIRST_NAME, MIDDLE_NAME, LAST_NAME).value();
        Name name2 = Name.create(FIRST_NAME, MIDDLE_NAME, LAST_NAME).value();
        assertThat(name1.equals(name2)).isTrue();
    }
}