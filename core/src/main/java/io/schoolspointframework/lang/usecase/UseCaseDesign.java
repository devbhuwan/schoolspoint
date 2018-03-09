package io.schoolspointframework.lang.usecase;

/**
 * @author Bhuwan Prasad Upadhyay
 */
public @interface UseCaseDesign {
    /**
     * @return mark as false if you don't want enable logging
     * before and after print log in the use case execute method.
     */
    boolean logMe() default true;
}
