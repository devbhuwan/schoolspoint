package io.schoolspointframework.accountancy;

import lombok.NonNull;

/**
 * @author Bhuwan Prasad Upadhyay
 */
public class PersistentAccountancy implements Accountancy {

    private AccountancyEntryRepository repository;

    @Override
    public <T extends AccountancyEntry> T add(@NonNull T accountancyEntry) {
        return null;
    }
}
