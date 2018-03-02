package io.schoolspointframework.core.ddd;

/**
 * @author Bhuwan Prasad Upadhyay
 */
public interface DomainEntity<ID extends EntityIdentifier> {
    ID getIdentifier();
}
