package io.schoolspointframework.student.domain;

import io.schoolspointframework.core.SchoolspointEntityIdentifier;

import javax.persistence.Embeddable;

/**
 * @author Bhuwan Prasad Upadhyay
 */
@Embeddable
class StudentIdentifier extends SchoolspointEntityIdentifier {

    StudentIdentifier() {
        super();
    }

}
