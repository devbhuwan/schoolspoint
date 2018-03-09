package io.schoolspointframework.accountancy;

/**
 * @author Bhuwan Prasad Upadhyay
 */
public interface Accountancy {

    // #5
    <T extends AccountancyEntry> T add(T accountancyEntry);

}
