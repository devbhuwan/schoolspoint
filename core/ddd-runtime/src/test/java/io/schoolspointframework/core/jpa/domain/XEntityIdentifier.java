package io.schoolspointframework.core.jpa.domain;

import io.schoolspointframework.core.ddd.annotations.DddEntityIdentifier;
import lombok.EqualsAndHashCode;

import java.util.UUID;

/**
 * @author Bhuwan Prasad Upadhyay
 */
@EqualsAndHashCode
@DddEntityIdentifier
class XEntityIdentifier implements XIdentifier {

    private String id;

    public XEntityIdentifier() {
        this.id = UUID.randomUUID().toString();
    }


}
