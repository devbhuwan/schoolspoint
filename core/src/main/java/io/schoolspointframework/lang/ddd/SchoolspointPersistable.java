package io.schoolspointframework.lang.ddd;

import org.springframework.data.domain.Persistable;

import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;

import static java.util.Objects.nonNull;

/**
 * @author Bhuwan Prasad Upadhyay
 */
@MappedSuperclass
public abstract class SchoolspointPersistable<PK extends SchoolspointIdentifier> implements DomainEntity<PK>, Persistable<PK> {

    @Transient
    public boolean isNew() {
        return nonNull(this.getId());
    }

    public String toString() {
        return String.format("Entity of type %s with id: %s", this.getClass().getName(), this.getId());
    }

    @Override
    public PK getId() {
        return getIdentifier();
    }

}
