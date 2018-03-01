package io.schoolspointframework.core;

import org.springframework.data.jpa.domain.AbstractPersistable;

/**
 * @author Bhuwan Prasad Upadhyay
 */
public abstract class AbstractEntity<ID extends SchoolspointEntityIdentifier> extends AbstractPersistable<ID> {

}
