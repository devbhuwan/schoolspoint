package io.schoolspointframework.accountancy.domain;

import java.math.BigDecimal;

/**
 * @author Bhuwan Prasad Upadhyay
 */
@FunctionalInterface
public interface FeeAccountancy {
    BigDecimal getFee(String gradeName);
}
