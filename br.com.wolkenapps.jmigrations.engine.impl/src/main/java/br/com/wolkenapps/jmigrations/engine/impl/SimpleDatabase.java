package br.com.wolkenapps.jmigrations.engine.impl;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import lombok.Getter;
import br.com.wolkenapps.jmigrations.api.DatabaseCommand;
import br.com.wolkenapps.jmigrations.api.Migration;
import br.com.wolkenapps.jmigrations.dsl.model.DatabaseObject;
import br.com.wolkenapps.jmigrations.engine.api.Database;
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
    public Boolean contains(DatabaseObject object) {
        return true; // TODO
    }

    public SimpleDatabase with(DatabaseCommandApplier... appliers) {
        this.appliers.addAll(Arrays.asList(appliers));
        return this;
    }

}
