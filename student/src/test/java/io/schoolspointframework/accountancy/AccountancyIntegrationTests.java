package io.schoolspointframework.accountancy;

import io.schoolspointframework.AbstractIntegrationTests;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Bhuwan Prasad Upadhyay
 */
class AccountancyIntegrationTests extends AbstractIntegrationTests {

    @Autowired
    private Accountancy accountancy;

    @Test
    void rejectNullEntry() {

    }

}