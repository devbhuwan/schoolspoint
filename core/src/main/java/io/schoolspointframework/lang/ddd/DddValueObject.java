package io.schoolspointframework.lang.ddd;

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
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
