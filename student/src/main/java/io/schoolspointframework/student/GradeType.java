package io.schoolspointframework.student;

import static org.apache.commons.lang3.StringUtils.isBlank;

/**
 * @author Bhuwan Prasad Upadhyay
 */
enum GradeType {
    NURSERY,
    LKG,
    UKG,
    ONE,
    TWO,
    THREE,
    FOUR,
    FIVE,
    SIX,
    SEVEN,
    EIGHT,
    NINE,
    TEN,
    ELEVEN,
    TWELVE;

    public static GradeType valueOfOrElseGetDefault(String name) {
        return isBlank(name) ? GradeType.NURSERY : GradeType.valueOf(name);
    }
}
