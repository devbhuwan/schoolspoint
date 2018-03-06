package io.schoolspointframework.student.domain;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import static io.schoolspointframework.student.domain.RollNumber.START;

/**
 * @author Bhuwan Prasad Upadhyay
 */
@RequiredArgsConstructor
@Component
class PlusByOneRollNumberGenerator implements RollNumberGenerator {

    private final @NonNull
    StudentRepository studentRepository;

    @Override
    public Integer newSequence(Grade grade) {
        return studentRepository
                .findFirstByGradeOrderByRollNumberDesc(grade)
                .map(Student::getRollNumber)
                .orElse(START).plusOne();
    }

}
