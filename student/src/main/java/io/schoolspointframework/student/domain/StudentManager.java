package io.schoolspointframework.student.domain;

import org.springframework.data.util.Streamable;

import java.util.Optional;

/**
 * @author Bhuwan Prasad Upadhyay
 */
public interface StudentManager<T extends Student> {
    T save(T student);

    Optional<T> get(StudentIdentifier studentIdentifier);

    boolean contains(StudentIdentifier studentIdentifier);

    void getByRollNumber(RollNumber rollNumber);

    Streamable<T> getAllByGrade(Grade grade);
}
