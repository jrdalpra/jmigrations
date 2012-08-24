package br.com.wolkenapps.jmigrations.model.domain;

import java.util.*;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.ExtensionMethod;
import br.com.wolkenapps.jmigrations.model.commands.alter.actions.stereotypes.CanBeRenamed;
import br.com.wolkenapps.jmigrations.model.commons.options.PrimaryKey;
import br.com.wolkenapps.jmigrations.model.commons.stereotype.HasOptions;

@RequiredArgsConstructor
@ExtensionMethod({ Arrays.class })
public class Table implements HasOptions<Table>, CanBeRenamed {

    @Getter
    private final String      name;

    private final Set<Option> options;

    private final Set<Column> columns;

    public Table(String name) {
        this(name, new LinkedHashSet<Option>(), new LinkedHashSet<Column>());
    }

    public Table() {
        this(null, null, null);
    }

    @Override
    public Table withOptions(Option... options) {
        this.options.addAll(options.asList());
        return this;
    }

    @Override
    public Set<Option> options() {
        return HasOptions.Trait.options(this.options);
    }

    @Override
    public <O extends Option> Boolean contains(Class<O> option) {
        return HasOptions.Trait.contains(this, option);
    }

    @Override
    public Boolean contains(String optionRepresentation) {
        return HasOptions.Trait.contains(this, optionRepresentation);
    }

    public Set<Column> columns() {
        return Collections.unmodifiableSet(columns);
    }

    public Table columns(Column... columns) {
        this.columns.addAll(columns.asList());
        return this;
    }

    public Table primaryKey(Column... columns) {
        return withOptions(new PrimaryKey(columns.asList()));
    }

    public Table primaryKey(String... columns) {
        return withOptions(new PrimaryKey(columns));
    }

}
