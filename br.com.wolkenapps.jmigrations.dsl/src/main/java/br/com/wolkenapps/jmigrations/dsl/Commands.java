package br.com.wolkenapps.jmigrations.dsl;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import br.com.wolkenapps.jmigrations.model.commands.*;
import br.com.wolkenapps.jmigrations.model.commands.alter.AlterAction;
import br.com.wolkenapps.jmigrations.model.domain.Table;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class Commands {

    public static <Something> Create<Something> create(Something toBeCreated) {
        return new Create<Something>(toBeCreated);
    }

    public static <Something> Alter<Something> alter(Something toBeChanged, AlterAction<?> action) {
        return new Alter<Something>(toBeChanged, action);
    }

    public static <Something> Drop<Something> drop(Something toBeDropped) {
        return new Drop<Something>(toBeDropped);
    }

    public static InsertInto insertInto(Table target) {
        return new InsertInto(target);
    }

    public static InsertInto insertInto(String target) {
        return new InsertInto(target);
    }

}
