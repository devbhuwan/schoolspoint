package io.schoolspointframework.student.domain;

import io.schoolspointframework.core.AbstractEntity;
import io.schoolspointframework.core.ddd.Response;
import io.schoolspointframework.core.ddd.ValidationError;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Optional;
import java.util.Set;

import static io.schoolspointframework.core.ddd.MessageFormats.MUST_BE_NOT_NULL;
import static io.schoolspointframework.core.ddd.Response.reduce;
import static io.schoolspointframework.core.ddd.ValidationError.raiseIfWithMessageFormat;
import static java.util.Objects.isNull;

/**
 * @author Bhuwan Prasad Upadhyay
 */
@Getter
@Entity
@Table(name = "STUDENTS")
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Student extends AbstractEntity<StudentIdentifier> {

    static final Student NULL = new Student(Name.NULL, Address.NULL, Grade.NULL, RollNumber.NULL);
    private final Name name;
    private final Address address;
    private final Grade grade;
    private final RollNumber rollNumber;


    public static Response<Student> create(@NonNull final StudentInfoParameters params, @NonNull final RollNumberGenerator rollNumberGenerator) {
        Response<Name> name = Name.create(params.getFirstName(), params.getMiddleName(), params.getLastName());
        Response<Address> address = Address.create(params.getAddressName(), params.getStreet(), params.getCity(), params.getZipCode());
        Response<Grade> grade = Grade.create(GradeType.valueOfOrElseGetDefault(params.getGradeType()), params.getGroup());
        Response<RollNumber> rollNumber = RollNumber.create(grade.value(), rollNumberGenerator);
        Response<Optional<Void>> response = Response.mergeErrors(reduce(name, address, grade, rollNumber), validateEntry(name.value(), address.value(), grade.value(), rollNumber.value()));
        if (Response.hasError(response))
            return Response.failure(Student.NULL, response.error().validationErrors());
        return Response.success(new Student(name.value(), address.value(), grade.value(), rollNumber.value()));
    }

    private static Set<ValidationError> validateEntry(Name name, Address address, Grade grade, RollNumber rollNumber) {
        return ValidationError.of(
                raiseIfWithMessageFormat(isNull(name), "name", MUST_BE_NOT_NULL),
                raiseIfWithMessageFormat(isNull(address), "address", MUST_BE_NOT_NULL),
                raiseIfWithMessageFormat(isNull(grade), "grade", MUST_BE_NOT_NULL),
                raiseIfWithMessageFormat(isNull(rollNumber), "rollNumber", MUST_BE_NOT_NULL)
        );
    }

}
