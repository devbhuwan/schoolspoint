package io.schoolspointframework.student;

/**
 * @author Bhuwan Prasad Upadhyay
 */
@FunctionalInterface
public interface RollNumberGenerator {

    Integer newSequence(Grade grade);
}
