package io.schoolspointframework.lang.ddd;

import java.util.Objects;

/**
 * @author Bhuwan Prasad Upadhyay
 */
public abstract class ValueObject {

    @Override
    public int hashCode() {
        return valueHashCode();
    }

    protected abstract int valueHashCode();

    @Override
    public boolean equals(Object that) {
        return Objects.equals(this, that);
    }
}
