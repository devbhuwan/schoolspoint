package io.schoolspointframework.core.jpa;

import io.schoolspointframework.core.jpa.domain.EntityRepository;
import io.schoolspointframework.core.jpa.domain.XEntity;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.fail;


/**
 * @author Bhuwan Prasad Upadhyay
 */
@Disabled
@SpringBootTest(classes = DddRuntimeTestApp.class)
class DddEntityTransformerTests extends AbstractIntegrationTests {

    @Autowired
    private EntityRepository entityRepository;

    @Test
    void doesSaveEntityCorrectly() {
        try {
            entityRepository.save(new XEntity());
        } catch (Exception e) {
            fail("Unable to save entity");
        }
    }

}