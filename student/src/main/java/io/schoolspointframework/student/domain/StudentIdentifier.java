package io.schoolspointframework.student.domain;

import io.schoolspointframework.core.SchoolspointIdentifier;

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
