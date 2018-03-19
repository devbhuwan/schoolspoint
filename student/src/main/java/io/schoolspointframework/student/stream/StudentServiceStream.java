package io.schoolspointframework.student.stream;

/**
 * @author Bhuwan Prasad Upadhyay
 */
public interface StudentServiceStream {
    String OUTPUT = "student-service-out";

    Void send();
}
