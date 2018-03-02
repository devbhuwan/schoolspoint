package io.schoolspointframework.core.jpa.domain;

import io.schoolspointframework.core.ddd.annotations.DddValueObject;
import lombok.EqualsAndHashCode;

/**
 * @author Bhuwan Prasad Upadhyay
 */
@DddValueObject
@EqualsAndHashCode
class XName {
    private String firstName;
}
