package io.schoolspointframework.accountancy.domain;

import lombok.NonNull;

import java.math.BigDecimal;

/**
 * @author Bhuwan Prasad Upadhyay
 */
public class PersistentAccountancy implements Accountancy {

    private AccountancyEntryRepository repository;

    @Override
    public <T extends AccountancyEntry> T add(@NonNull T accountancyEntry) {
        return null;
    }

    @Override
    public BigDecimal getFee(String gradeName) {
        return null;
    }
}
