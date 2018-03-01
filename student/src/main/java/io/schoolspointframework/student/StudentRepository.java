package io.schoolspointframework.student;

import org.springframework.data.repository.CrudRepository;

/**
 * @author Bhuwan Prasad Upadhyay
 */
interface StudentRepository<T extends Student> extends CrudRepository<T, StudentIdentifier> {

    Iterable<T> findByGrade(Grade grade);
}
