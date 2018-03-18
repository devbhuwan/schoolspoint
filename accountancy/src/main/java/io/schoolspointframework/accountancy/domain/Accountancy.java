package io.schoolspointframework.accountancy.domain;

/**
 * @author Bhuwan Prasad Upadhyay
 */
public interface Accountancy extends FeeAccountancy {

    // #5
    <T extends AccountancyEntry> T add(T accountancyEntry);

}
