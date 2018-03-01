package io.schoolspointframework.student;

import io.schoolspointframework.core.ddd.InfoParameters;

/**
 * @author Bhuwan Prasad Upadhyay
 */
public interface StudentInfoParameters extends InfoParameters {
    String getFirstName();

    String getLastName();

    String getMiddleName();

    String getAddressName();

    String getGradeType();

    String getGroup();

    String getStreet();

    String getZipCode();

    String getCity();
}
