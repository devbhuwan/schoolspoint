package io.schoolspointframework.accountancy;

import io.schoolspointframework.student.domain.Student;
import io.schoolspointframework.student.event.NewApplicantRegisteredEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * @author Bhuwan Prasad Upadhyay
 */
@Slf4j
@Component
public class AccountancyEventListener {

    @EventListener
    public void handle(NewApplicantRegisteredEvent event) {
        Student student = event.getSource();
        LOG.info("Receiving [event={},source={}]", event.getClass().getName(), student);
    }
}
