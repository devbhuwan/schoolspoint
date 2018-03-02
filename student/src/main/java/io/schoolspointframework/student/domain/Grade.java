package io.schoolspointframework.student.domain;

import io.schoolspointframework.core.ddd.Response;
import io.schoolspointframework.core.ddd.annotations.DddValueObject;
import lombok.EqualsAndHashCode;

import javax.persistence.Embeddable;
import java.util.Objects;

import static org.apache.commons.lang3.StringUtils.EMPTY;
import static org.apache.commons.lang3.StringUtils.isBlank;

/**
 * @author Bhuwan Prasad Upadhyay
 */
@DddValueObject
@EqualsAndHashCode
@Embeddable
class Grade {

    public static final Grade NULL = new Grade(GradeType.NURSERY, EMPTY);
    private GradeType gradeType;
    private String gradeGroup;

    private Grade(GradeType gradeType, String gradeGroup) {
        this.gradeType = Objects.isNull(gradeType) ? GradeType.NURSERY : gradeType;
        this.gradeGroup = isBlank(gradeGroup) ? EMPTY : gradeGroup;
    }

    public static Response<Grade> create(GradeType gradeType, String group) {
        return Response.success(new Grade(gradeType, group));
    }
}
