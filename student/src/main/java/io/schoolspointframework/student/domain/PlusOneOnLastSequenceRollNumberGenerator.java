package io.schoolspointframework.student.domain;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * @author Bhuwan Prasad Upadhyay
 */
@RequiredArgsConstructor
class PlusOneOnLastSequenceRollNumberGenerator implements RollNumberGenerator {


    private final @NonNull
    StudentRepository<Student> studentRepository;

    @Override
    public Integer newSequence(Grade grade) {
        return null;
    }
}
