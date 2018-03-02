package io.schoolspointframework.student.endpoints;

import io.schoolspointframework.student.domain.StudentInfoParameters;
import lombok.Getter;

/**
 * @author Bhuwan Prasad Upadhyay
 */
@Getter
class EndpointStudentInfoParameters implements StudentInfoParameters {

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
