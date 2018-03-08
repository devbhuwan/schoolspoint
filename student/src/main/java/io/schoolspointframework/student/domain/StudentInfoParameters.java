package io.schoolspointframework.student.domain;


import io.schoolspointframework.lang.ddd.InfoParameters;

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
