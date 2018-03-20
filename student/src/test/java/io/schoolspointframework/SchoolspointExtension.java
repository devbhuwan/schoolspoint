package io.schoolspointframework;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 * @author Bhuwan Prasad Upadhyay
 */
public class SchoolspointExtension extends SpringExtension {

    @Override
    public void beforeAll(ExtensionContext context) throws Exception {
        super.beforeAll(context);
    }
}
