package io.schoolspointframework.accountancy.endpoints;

import io.schoolspointframework.accountancy.domain.AccountancyHttpEndpoints;
import io.schoolspointframework.accountancy.domain.FeeAccountancy;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * @author Bhuwan Prasad Upadhyay
 */
@RestController
@RequestMapping(AccountancyHttpEndpoints.BASE_URI)
@RequiredArgsConstructor
public class RestAccountancyEndpoints implements AccountancyHttpEndpoints {

    private final FeeAccountancy feeAccountancy;

    @Override
    @PostMapping(AccountancyHttpEndpoints.NORMAL_FEE)
    public BigDecimal getFee(String grade) {
        return feeAccountancy.getFee(grade);
    }
}
