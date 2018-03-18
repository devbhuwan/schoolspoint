package io.schoolspointframework.accountancy.endpoints;

import java.util.Set;

/**
 * @author Bhuwan Prasad Upadhyay
 */
public interface AccountancyEndpoints {

    String BASE_URI = "/accountancy";
    String CALCULATE_FEE = "/calculate-fee";

    @PostMapping(CALCULATE_FEE)
    Set<ResponseError> registerStudent(EndpointStudentInfoParameters params);

}
