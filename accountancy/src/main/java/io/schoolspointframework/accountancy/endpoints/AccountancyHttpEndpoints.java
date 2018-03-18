package io.schoolspointframework.accountancy.endpoints;

import io.schoolspointframework.accountancy.domain.Fee;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author Bhuwan Prasad Upadhyay
 */
public interface AccountancyHttpEndpoints {

    String BASE_URI = "/accountancy";
    String NORMAL_FEE = "/fee";

    @PostMapping(NORMAL_FEE)
    Fee getFee(String grade);

}
