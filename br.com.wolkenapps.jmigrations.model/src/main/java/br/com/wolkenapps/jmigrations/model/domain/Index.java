package br.com.wolkenapps.jmigrations.model.domain;

import java.util.*;

import lombok.*;
import lombok.experimental.ExtensionMethod;
import br.com.wolkenapps.jmigrations.model.commands.alter.actions.stereotypes.CanBeRenamed;
import br.com.wolkenapps.jmigrations.model.commons.options.UniqueConstraint;
import br.com.wolkenapps.jmigrations.model.commons.stereotype.HasOptions;

@RequiredArgsConstructor
@EqualsAndHashCode(of = { "name" })
@ExtensionMethod({ Arrays.class })
public class Index implements HasOptions<Index>, CanBeRenamed {

    @Getter
    private final String           name;

    private final Set<IndexColumn> columns;

    @Getter
    private Table                  target;

    private Set<Option>            options = new LinkedHashSet<>();

    public Index(String name) {
        this(name, new LinkedHashSet<IndexColumn>());
    }

    public Index() {
        this(null, new LinkedHashSet<IndexColumn>());
    }

    @Override
    public Index withOptions(Option... options) {
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

    public Index on(String table) {
        return on(new Table(table));
    }

    public Index on(Table table) {
        this.target = table;
        return this;
    }

    public Index columns(List<IndexColumn> IndexColumns) {
        this.columns.addAll(IndexColumns);
        return this;
    }

    public Index columns(IndexColumn... columns) {
        return columns(columns.asList());
    }

    public Index columns(String... columns) {
        return columns(IndexColumn.Utils.createBasedOn(columns));
    }

    public Index column(String column) {
        return columns(column);
    }

    public Index column(IndexColumn column) {
        return columns(column);
    }

    public Set<IndexColumn> getColumns() {
        return Collections.unmodifiableSet(this.columns);
    }

    public Index unique() {
        return withOptions(new UniqueConstraint());
    }

}
