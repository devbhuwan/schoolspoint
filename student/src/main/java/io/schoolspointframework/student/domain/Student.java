package io.schoolspointframework.student.domain;

import io.schoolspointframework.lang.ddd.Response;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.function.Supplier;

import static io.schoolspointframework.student.domain.GradeType.valueOfOrElseGetDefault;

/**
 * @author Bhuwan Prasad Upadhyay
 */
@Getter
@Entity
@Table(name = "STUDENTS")
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Student extends AbstractPersistable<Long> {

    static final Student NULL = new Student(Name.NULL, Address.NULL, Grade.NULL, RollNumber.NULL);
    private final Name name;
    private final Address address;
    private final Grade grade;
    private final RollNumber rollNumber;


    public static Response<Student> create(@NonNull final StudentInfoParameters params, @NonNull final RollNumberGenerator rollNumberGenerator) {
        Response<Name> name = Name.create(params.getFirstName(), params.getMiddleName(), params.getLastName());
        Response<Address> address = Address.create(params.getAddressName(), params.getStreet(), params.getCity(), params.getZipCode());
        Response<Grade> grade = Grade.create(valueOfOrElseGetDefault(params.getGradeType()), params.getGroup());
        Response<RollNumber> rollNumber = RollNumber.create(grade.value(), rollNumberGenerator);
        return Response
                .of(Student.class, name, address, grade, rollNumber)
                .raiseIfNull(name.value(), "studentName")
                .raiseIfNull(address.value(), "studentAddress")
                .raiseIfNull(grade.value(), "studentGrade")
                .raiseIfNull(rollNumber.value(), "studentRollNumber")
                .getOrElse(student(name.value(), address.value(), grade.value(), rollNumber.value()), defaultStudent());
    }

    private static Supplier<Student> defaultStudent() {
        return () -> Student.NULL;
    }

    private static Supplier<Student> student(Name name, Address address, Grade grade, RollNumber rollNumber) {
        return () -> new Student(name, address, grade, rollNumber);
    }

}
