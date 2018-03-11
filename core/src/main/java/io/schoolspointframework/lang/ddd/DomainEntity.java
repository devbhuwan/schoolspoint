package io.schoolspointframework.lang.ddd;

/**
 * @author Bhuwan Prasad Upadhyay
 */
public interface DomainEntity<PK extends EntityIdentifier> {
    PK getIdentifier();
}
