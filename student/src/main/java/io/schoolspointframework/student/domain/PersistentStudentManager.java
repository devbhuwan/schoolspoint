package io.schoolspointframework.student.domain;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.Optional;

/**
 * @author Bhuwan Prasad Upadhyay
 */
@Transactional
@Service
@RequiredArgsConstructor
class PersistentStudentManager<T extends Student> implements StudentManager<Student> {

    private final @NonNull
    StudentRepository<Student> studentRepository;

    @Override
    public Student save(Student student) {
        Assert.notNull(student, "Student must not be null");
        return studentRepository.save(student);
    }

    @Override
    public Optional<Student> get(StudentIdentifier studentIdentifier) {
        Assert.notNull(studentIdentifier, "studentIdentifier must not be null");
        return studentRepository.findById(studentIdentifier);
    }

    @Override
    public boolean contains(StudentIdentifier studentIdentifier) {
        Assert.notNull(studentIdentifier, "studentIdentifier must not be null");
        return studentRepository.existsById(studentIdentifier);
    }

    @Override
    public void getByRollNumber(RollNumber rollNumber) {

    }

    @Override
    public Streamable<Student> getAllByGrade(Grade grade) {
        return null;
    }

}
