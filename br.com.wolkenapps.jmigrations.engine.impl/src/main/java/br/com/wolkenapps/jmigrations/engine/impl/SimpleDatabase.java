package br.com.wolkenapps.jmigrations.engine.impl;

import java.util.*;

import lombok.Getter;
import br.com.wolkenapps.jmigrations.api.*;
import br.com.wolkenapps.jmigrations.engine.api.internal.DatabaseCommandApplier;

public class SimpleDatabase implements Database {

    // TODO @Inject
    @Getter
    private Set<DatabaseCommandApplier> appliers = new HashSet<>();

    @Override
    public void up(Migration... migrations) {
        for (Migration migration : migrations) {
            apply(migration.up());
        }
    }

    private void apply(DatabaseCommand... commands) {
        to_next_command:
        for (DatabaseCommand command : commands) {
            for (DatabaseCommandApplier applier : appliers) {
                if (applier.accepts(command)) {
                    applier.applies(command);
                    continue to_next_command;
                }
            }
            throw new RuntimeException("Command " + command + " has no Applier!");
        }
    }

    @Override
    public void down(Migration... migrations) {
        for (Migration migration : migrations) {
            apply(migration.down());
        }
    }

    @Override
    public Boolean contains(Object object) {
        return true; // TODO
    }

    public SimpleDatabase with(DatabaseCommandApplier... appliers) {
        this.appliers.addAll(Arrays.asList(appliers));
        return this;
    }

}
