package io.schoolspointframework.student.domain;

import io.schoolspointframework.lang.ddd.SchoolspointIdentifier;

import javax.persistence.Embeddable;

/**
 * @author Bhuwan Prasad Upadhyay
 */
@Embeddable
final class StudentIdentifier extends SchoolspointIdentifier {
    StudentIdentifier() {
        super();
    }
}
