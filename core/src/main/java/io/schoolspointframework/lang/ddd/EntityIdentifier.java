package io.schoolspointframework.lang.ddd;

import java.io.Serializable;

/**
 * @author Bhuwan Prasad Upadhyay
 */
public interface EntityIdentifier<PK> extends Serializable {
    PK getId();
}
