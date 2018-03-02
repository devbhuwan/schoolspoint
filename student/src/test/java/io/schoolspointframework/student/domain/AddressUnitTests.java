package io.schoolspointframework.student.domain;

import org.junit.Test;

import static org.apache.commons.lang3.StringUtils.EMPTY;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Bhuwan Prasad Upadhyay
 */
public class AddressUnitTests {

    public static final Address SHORT_ADDRESS = Address.create("Lamki, Kailali", EMPTY, EMPTY, EMPTY).value();
    public static final Address FULL_ADDRESS = Address.create("Lamki, Kailali", "Lamki Bazzar", "Lamki", "12312").value();

    @Test
    public void rejectsBlankName() {
        assertThat(Address.create(null, EMPTY, EMPTY, EMPTY).error().validationErrors()).extracting("causedBy").contains("name");
        assertThat(Address.create("  ", EMPTY, EMPTY, EMPTY).error().validationErrors()).extracting("causedBy").contains("name");
    }

    @Test
    public void equalsTwoAddressIfBothHaveSameNameAndStreetAndCityAndZipCode() {
        assertThat(SHORT_ADDRESS.equals(SHORT_ADDRESS)).isTrue();
        assertThat(FULL_ADDRESS.equals(SHORT_ADDRESS)).isFalse();
        assertThat(FULL_ADDRESS.equals(FULL_ADDRESS)).isTrue();
    }
}