package br.com.wolkenapps.jmigrations.model.domain;

import java.util.*;

import lombok.*;
import lombok.experimental.ExtensionMethod;
import br.com.wolkenapps.jmigrations.model.commons.stereotype.HasOptions;
import br.com.wolkenapps.jmigrations.model.domain.foreignkeys.options.References;
import br.com.wolkenapps.utils.ConfirmsThat;

@ExtensionMethod({ Arrays.class, ConfirmsThat.class })
@EqualsAndHashCode(of = { "name" })
public class ForeignKey implements Option, HasOptions<ForeignKey> {

    @Getter
    private final String      name;

    @Getter
    private Table             thisSide;

    private final Set<Option> options;

    public ForeignKey(String name, Table thisSide) {
        this(name, thisSide, new LinkedHashSet<Option>());
    }

    public ForeignKey(String name) {
        this(name, new Table());
    }

    public ForeignKey(String name, Table thisSide, Set<Option> options) {
        this.name = name;
        this.thisSide = thisSide;
        this.options = options;
    }

    @Override
    public ForeignKey withOptions(Option... options) {
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

    public Set<Column> getColumns() {
        return this.thisSide.columns();
    }

    @Override
    public String representation() {
        return ForeignKey.class.getSimpleName().toLowerCase();
    }

    public ForeignKey columns(Column... columns) {
        this.thisSide.columns(columns);
        return this;
    }

    public ForeignKey columns(String... columns) {
        this.thisSide.columns(columns);
        return this;
    }

    public ForeignKey column(Column column) {
        return this.columns(column);
    }

    public ForeignKey column(String column) {
        return this.columns(column);
    }

    public ForeignKey table(Table thisSide) {
        this.thisSide = thisSide;
        return this;
    }

    public ForeignKey table(String thisSide) {
        return table(new Table(thisSide));
    }

    public ForeignKey references(References otherSide) {
        return withOptions(otherSide);
    }

    public ForeignKey references(Table otherSide) {
        return references(new References(otherSide));
    }

}
