package io.schoolspointframework.student.domain;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Random;

/**
 * @author Bhuwan Prasad Upadhyay
 */
@RequiredArgsConstructor
@Component
class PlusByOneRollNumberGenerator implements RollNumberGenerator {

    private final @NonNull
    StudentRepository<Student> studentRepository;

    @Override
    public Integer newSequence(Grade grade) {
        return new Random().nextInt();
    }
}
