package io.schoolspointframework.student.domain;

import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

/**
 * @author Bhuwan Prasad Upadhyay
 */
interface StudentRepository extends PagingAndSortingRepository<Student, Long> {

    Optional<Student> findFirstByGradeOrderByRollNumberDesc(Grade grade);
}
