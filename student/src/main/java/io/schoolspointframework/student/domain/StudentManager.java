package io.schoolspointframework.student.domain;

/**
 * @author Bhuwan Prasad Upadhyay
 */
public interface StudentManager<T extends Student> {
    T save(T student);
}
