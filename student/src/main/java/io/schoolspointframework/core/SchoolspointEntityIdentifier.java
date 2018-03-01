package io.schoolspointframework.core;

import io.schoolspointframework.core.ddd.EntityIdentifier;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.util.UUID;

/**
 * @author Bhuwan Prasad Upadhyay
 */
@MappedSuperclass
@Access(AccessType.FIELD)
@RequiredArgsConstructor
@EqualsAndHashCode
@Getter
public class SchoolspointEntityIdentifier implements EntityIdentifier<String>, Serializable {

    private final String id;

    public SchoolspointEntityIdentifier() {
        this.id = UUID.randomUUID().toString();
    }

}
