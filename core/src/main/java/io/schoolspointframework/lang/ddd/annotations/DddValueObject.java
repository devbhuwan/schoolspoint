package io.schoolspointframework.lang.ddd.annotations;

import java.lang.annotation.*;

/**
 * @author Bhuwan Prasad Upadhyay
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DddValueObject {
    /*
     * There are some objects that have no conceptual identities.
     * These objects are called value objects.
     * We must remember that we are not talking about Id attribute of our database rather
     * we are discussing about an id that an object really needs.
     * Value objects are immutable. So they cannot be changed.
     * We don’t care about any specific instance of value objects.
     * If we need to delete a value object we will destroy the whole object
     * and success a new one.
     * It should be noted that one system’s  value objects may become an
     * entity and an entity may become to value objects in another system
     * depending on different application requirements.
     *
     */
}
