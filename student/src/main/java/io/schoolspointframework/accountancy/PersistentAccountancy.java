package io.schoolspointframework.accountancy;

import lombok.NonNull;
import org.springframework.stereotype.Component;

/**
 * @author Bhuwan Prasad Upadhyay
 */
@Component
public class PersistentAccountancy implements Accountancy {

    private AccountancyEntryRepository repository;

    @Override
    public <T extends AccountancyEntry> T add(@NonNull T accountancyEntry) {
        return null;
    }
}
