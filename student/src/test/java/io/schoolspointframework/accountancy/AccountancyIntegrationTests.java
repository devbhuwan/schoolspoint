package io.schoolspointframework.accountancy;

import io.schoolspointframework.AbstractIntegrationTests;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Bhuwan Prasad Upadhyay
 */
public class AccountancyIntegrationTests extends AbstractIntegrationTests {

    @Autowired
    private Accountancy accountancy;

    @Test
    public void rejectNullEntry() {

    }

}