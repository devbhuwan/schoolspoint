package io.schoolspointframework.lang.ddd;

/**
 * @author Bhuwan Prasad Upadhyay
 */
public interface DomainEntity<ID extends EntityIdentifier> {
    ID getIdentifier();
}
