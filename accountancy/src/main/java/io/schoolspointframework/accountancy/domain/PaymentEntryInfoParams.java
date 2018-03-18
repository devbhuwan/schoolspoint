package io.schoolspointframework.accountancy.domain;

import io.schoolspointframework.lang.ddd.EntityIdentifier;
import io.schoolspointframework.lang.ddd.InfoParameters;

import java.math.BigDecimal;

/**
 * @author Bhuwan Prasad Upadhyay
 */
interface PaymentEntryInfoParams<T extends EntityIdentifier> extends InfoParameters {

    T getPaidBy();

    BigDecimal getPaidAmount();

}
