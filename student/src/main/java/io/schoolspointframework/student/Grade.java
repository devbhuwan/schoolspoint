package io.schoolspointframework.student;

import io.schoolspointframework.core.ddd.Response;
import io.schoolspointframework.core.ddd.annotations.DddValueObject;
import lombok.EqualsAndHashCode;

import java.util.Objects;

import static org.apache.commons.lang3.StringUtils.EMPTY;
import static org.apache.commons.lang3.StringUtils.isBlank;

/**
 * @author Bhuwan Prasad Upadhyay
 */
@DddValueObject
@EqualsAndHashCode
class Grade {

    public static final Grade NULL = new Grade(GradeType.NURSERY, EMPTY);
    private GradeType gradeType;
    private String group;

    private Grade(GradeType gradeType, String group) {
        this.gradeType = Objects.isNull(gradeType) ? GradeType.NURSERY : gradeType;
        this.group = isBlank(group) ? EMPTY : group;
    }

    public static Response<Grade> create(GradeType gradeType, String group) {
        return Response.success(new Grade(gradeType, group));
    }
}
