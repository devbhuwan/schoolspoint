package io.schoolspointframework.student.endpoints;

import io.schoolspointframework.student.domain.StudentInfoParameters;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author Bhuwan Prasad Upadhyay
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EndpointStudentInfoParameters implements StudentInfoParameters {

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
