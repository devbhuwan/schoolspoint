package io.schoolspointframework.student.domain;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Objects;

import static org.apache.commons.lang3.StringUtils.EMPTY;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Bhuwan Prasad Upadhyay
 */
class AddressUnitTests {

    private Address SHORT_ADDRESS;
    private Address FULL_ADDRESS;

    @BeforeEach
    void setUp() {
        SHORT_ADDRESS = Address.create("Lamki, Kailali", EMPTY, EMPTY, EMPTY).value();
        FULL_ADDRESS = Address.create("Lamki, Kailali", "Lamki Bazzar", "Lamki", "12312").value();
    }

    @Test
    void rejectsBlankName() {
        assertThat(Address.create(null, EMPTY, EMPTY, EMPTY).errors()).extracting("causedBy").contains("addressName");
        assertThat(Address.create("  ", EMPTY, EMPTY, EMPTY).errors()).extracting("causedBy").contains("addressName");
    }

    @Test
    void equalsTwoAddressIfBothHaveSameNameAndStreetAndCityAndZipCode() {
        assertThat(Objects.equals(SHORT_ADDRESS, SHORT_ADDRESS)).isTrue();
        assertThat(Objects.equals(FULL_ADDRESS, SHORT_ADDRESS)).isFalse();
        assertThat(Objects.equals(FULL_ADDRESS, FULL_ADDRESS)).isTrue();
    }
}