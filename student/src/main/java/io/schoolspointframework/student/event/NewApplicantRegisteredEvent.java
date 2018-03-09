package io.schoolspointframework.student.event;

import io.schoolspointframework.core.ApplicationDomainEvent;
import io.schoolspointframework.student.domain.Student;

/**
 * @author Bhuwan Prasad Upadhyay
 */
public class NewApplicantRegisteredEvent extends ApplicationDomainEvent<Student> {

    public NewApplicantRegisteredEvent(Student e) {
        super(e);
    }
}