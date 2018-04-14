package io.schoolspointframework.student.domain;

import io.github.devbhuwan.student.spec.NewApplicant;
import io.schoolspointframework.lang.ddd.Response;
import io.schoolspointframework.lang.ddd.SchoolspointPersistable;
import lombok.*;

import javax.persistence.EmbeddedId;
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
@NoArgsConstructor(force = true, access = AccessLevel.PACKAGE)
public class Student extends SchoolspointPersistable<StudentIdentifier> {

    static final Student NULL = new Student(Name.NULL, Address.NULL, Grade.NULL, RollNumber.NULL);
    private final Name name;
    private final Address address;
    private final Grade grade;
    private final RollNumber rollNumber;
    @EmbeddedId
    private StudentIdentifier studentIdentifier = new StudentIdentifier();

    public Student(Name name, Address address, Grade grade, RollNumber rollNumber) {
        this.name = name;
        this.address = address;
        this.grade = grade;
        this.rollNumber = rollNumber;
    }

    public static Response<Student> create(@NonNull final NewApplicant applicant,
                                           @NonNull final RollNumberGenerator rollNumberGenerator) {
        NewApplicant.NameType nameType = applicant.getName();
        NewApplicant.AddressType addressType = applicant.getAddress();
        NewApplicant.GradeType gradeType = applicant.getGrade();

        Response<Name> name = Name.create(nameType.getFirstName(), nameType.getMiddleName(), nameType.getLastName());
        Response<Address> address = Address.create(addressType.getName(), addressType.getStreet(), addressType.getCity(), addressType.getZipCode());
        Response<Grade> grade = Grade.create(valueOfOrElseGetDefault(gradeType.getGradeType()), gradeType.getGroup());
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

    @Override
    public StudentIdentifier getIdentifier() {
        return studentIdentifier;
    }

}
