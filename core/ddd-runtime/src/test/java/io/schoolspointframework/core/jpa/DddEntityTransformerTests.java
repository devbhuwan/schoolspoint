package io.schoolspointframework.core.jpa;

import io.schoolspointframework.core.jpa.domain.EntityRepository;
import io.schoolspointframework.core.jpa.domain.XEntity;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.fail;

/**
 * @author Bhuwan Prasad Upadhyay
 */
@Ignore
@SpringBootTest(classes = DddRuntimeTestApp.class)
public class DddEntityTransformerTests extends AbstractIntegrationTests {

    @Autowired
    private EntityRepository entityRepository;

    @Test
    public void doesSaveEntityCorrectly() {
        try {
            entityRepository.save(new XEntity());
        } catch (Exception e) {
            fail("Unable to save entity");
        }
    }

    @Test
    public void name() {
    }
}