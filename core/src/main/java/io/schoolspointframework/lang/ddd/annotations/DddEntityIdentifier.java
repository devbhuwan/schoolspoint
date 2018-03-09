package io.schoolspointframework.lang.ddd.annotations;

import java.lang.annotation.*;

/**
 * @author Bhuwan Prasad Upadhyay
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DddEntityIdentifier {
    /*
     *   Entities are objects with conceptual identity.
     *   They have the identity so that we can track and distinguish
     *   them with their identity.
     *   An entity should not have only getters and setters rather
     *   it should encapsulate all of its behavior means
     *   it can have methods that is related to its behavior
     *   or indicates its behavior. Entities are mutable.
     *   We can change entities’ attribute without changing its identity
     *   but we don’t need to destroy the whole entity for it.
     */
}
