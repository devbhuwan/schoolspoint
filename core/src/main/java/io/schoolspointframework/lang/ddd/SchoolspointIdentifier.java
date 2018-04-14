package io.schoolspointframework.lang.ddd;

import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.MappedSuperclass;
import java.util.UUID;

/**
 * @author Bhuwan Prasad Upadhyay
 */
@MappedSuperclass
@EqualsAndHashCode
@ToString
public class SchoolspointIdentifier implements EntityIdentifier<String> {

    private final String id;

    public SchoolspointIdentifier() {
        this.id = UUID.randomUUID().toString();
    }

    @Override
    public String getId() {
        return id;
    }
}
