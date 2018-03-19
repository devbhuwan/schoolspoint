package io.schoolspointframework.accountancy.domain;

import java.math.BigDecimal;

/**
 * @author Bhuwan Prasad Upadhyay
 */
public interface AccountancyHttpEndpoints {

    String BASE_URI = "/accountancy";
    String NORMAL_FEE = "/fee";

    BigDecimal getFee(String grade);

}
