package io.schoolspointframework.core.cleancode.usecase;

import org.junit.jupiter.api.Test;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.Temporal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.time.DayOfWeek.MONDAY;
import static java.time.DayOfWeek.SUNDAY;
import static java.time.Period.between;
import static java.time.temporal.TemporalAdjusters.next;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Bhuwan Prasad Upadhyay
 */
class UseCaseLoggingInjectorTransformerTest {

    @Test
    void nextStep() {
        boolean isSunday = true;
        boolean isMonday = true;
        Map<DayOfWeek, Temporal> steps = new HashMap<>();
        steps.put(SUNDAY, next(SUNDAY).adjustInto(LocalDate.now()));
        steps.put(MONDAY, next(MONDAY).adjustInto(LocalDate.now()));
        List<Integer> integers = steps.entrySet().stream().map(e -> between(LocalDate.now(), LocalDate.from(e.getValue())).getDays()).sorted()
                .collect(Collectors.toList());
        assertEquals(Integer.valueOf(3), integers.get(0));
    }
}