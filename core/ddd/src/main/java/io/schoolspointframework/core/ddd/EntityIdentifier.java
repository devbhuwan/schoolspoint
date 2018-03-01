package io.schoolspointframework.core.ddd;

import java.io.Serializable;

/**
 * @author Bhuwan Prasad Upadhyay
 */
public interface EntityIdentifier<ID> extends Serializable {
    ID getId();
}
