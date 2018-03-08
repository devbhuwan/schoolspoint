package io.schoolspointframework.student.domain;

import io.schoolspointframework.lang.ddd.Response;
import io.schoolspointframework.lang.ddd.annotations.DddValueObject;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import java.util.function.Supplier;

import static io.schoolspointframework.student.domain.GradeType.NURSERY;
import static java.util.Objects.isNull;
import static org.apache.commons.lang3.StringUtils.EMPTY;
import static org.apache.commons.lang3.StringUtils.isBlank;

/**
 * @author Bhuwan Prasad Upadhyay
 */
@DddValueObject
@EqualsAndHashCode
@Embeddable
@Getter(AccessLevel.PACKAGE)
@NoArgsConstructor(force = true, access = AccessLevel.PACKAGE)
class Grade {

    public static final Grade NULL = new Grade(NURSERY, EMPTY);
    private GradeType gradeType;
    private String gradeGroup;

    private Grade(GradeType gradeType, String gradeGroup) {
        this.gradeType = isNull(gradeType) ? NURSERY : gradeType;
        this.gradeGroup = isBlank(gradeGroup) ? EMPTY : gradeGroup;
    }

    public static Response<Grade> create(GradeType gradeType, String group) {
        return Response.create(Grade.class).getOrElse(grade(gradeType, group), defaultGrade());
    }

    private static Supplier<Grade> grade(GradeType gradeType, String group) {
        return () -> new Grade(gradeType, group);
    }

    private static Supplier<Grade> defaultGrade() {
        return () -> Grade.NULL;
    }
}
