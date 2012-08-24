package br.com.wolkenapps.jmigrations.dsl;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import br.com.wolkenapps.jmigrations.model.commands.Drop;
import br.com.wolkenapps.jmigrations.model.commands.alter.actions.*;
import br.com.wolkenapps.jmigrations.model.commands.alter.actions.Rename.Self;
import br.com.wolkenapps.jmigrations.model.commands.alter.actions.stereotypes.CanBeRenamed;
import br.com.wolkenapps.jmigrations.model.domain.Column;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class AlterActions {

    public static <Something> Add<Something> add(Something toBeAdded) {
        return new Add<Something>(toBeAdded);
    }

    public static <Something> Drop<Something> drop_(Something toBeDropped) {
        return new Drop<Something>(toBeDropped);
    }

    public static <Something extends CanBeRenamed> Rename<Something> rename(Something from, Something to) {
        return new Rename<>(from, to);
    }

    public static Rename<Column> renameColumnFromTo(String from, String to) {
        return rename(new Column(from), new Column(to));
    }

    public static Rename<Self> renameSelfTo(String newName) {
        return new Rename<>(new Self(null, null), new Self(null, newName));
    }

    public static <Something> ChangeOptions<Something> change(Something toBeChanged) {
        return new ChangeOptions<Something>(toBeChanged);
    }

}
