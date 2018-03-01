package io.schoolspointframework.student;

import lombok.Builder;
import lombok.Getter;

/**
 * @author Bhuwan Prasad Upadhyay
 */
@Getter
@Builder
public class FakeStudentInfoParameters implements StudentInfoParameters {

    private String firstName;
    private String lastName;
    private String middleName;
    private String addressName;
    private String gradeType;
    private String group;
    private String street;
    private String zipCode;
    private String city;

}
