package io.schoolspointframework.student.domain;

/**
 * @author Bhuwan Prasad Upadhyay
 */
@FunctionalInterface
public interface RollNumberGenerator {

    Integer newSequence(Grade grade);
}
