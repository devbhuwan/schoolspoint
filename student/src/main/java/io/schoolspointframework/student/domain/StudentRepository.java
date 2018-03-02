package io.schoolspointframework.student.domain;

import org.springframework.data.repository.CrudRepository;

/**
 * @author Bhuwan Prasad Upadhyay
 */
interface StudentRepository<T extends Student> extends CrudRepository<T, Long> {

    Iterable<T> findByGrade(Grade grade);
}
