package io.schoolspointframework.student.domain;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

/**
 * @author Bhuwan Prasad Upadhyay
 */
@Transactional
@Service
@RequiredArgsConstructor
class PersistentStudentManager<T extends Student> implements StudentManager<Student> {

    private final @NonNull
    StudentRepository studentRepository;

    @Override
    public Student save(Student student) {
        Assert.notNull(student, "Student must not be null");
        return studentRepository.save(student);
    }

}
