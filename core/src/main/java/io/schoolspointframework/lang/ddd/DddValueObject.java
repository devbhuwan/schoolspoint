package io.schoolspointframework.lang.ddd;

import java.util.Objects;

/**
 * @author Bhuwan Prasad Upadhyay
 */
public abstract class DddValueObject {

    @Override
    public int hashCode() {
        return valueHashCode();
    }

    public abstract int valueHashCode();

    @Override
    public boolean equals(Object that) {
        return Objects.equals(this, that);
    }
}
