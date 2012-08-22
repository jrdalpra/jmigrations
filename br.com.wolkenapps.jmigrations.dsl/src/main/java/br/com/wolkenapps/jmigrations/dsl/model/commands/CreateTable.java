package br.com.wolkenapps.jmigrations.dsl.model.commands;

import static java.util.Arrays.asList;

import java.util.*;

import lombok.Getter;
import br.com.wolkenapps.jmigrations.api.DatabaseCommand;
import br.com.wolkenapps.jmigrations.dsl.model.column.Column;
import br.com.wolkenapps.jmigrations.dsl.model.commons.options.DatabaseObjectOption;
import br.com.wolkenapps.jmigrations.dsl.model.commons.stereotype.CanUseIfNotExists;
import br.com.wolkenapps.jmigrations.dsl.model.commons.stereotype.HasOptions;
import br.com.wolkenapps.jmigrations.dsl.model.table.Table;

public class CreateTable implements DatabaseCommand, HasOptions<CreateTable>, CanUseIfNotExists {

    @Getter
    private final Table table;

    public CreateTable() {
        this(null);
    }
    
    public CreateTable(String name) {
        this.table = new Table(name);
    }

    private Set<Column>               columns = new LinkedHashSet<>();

    private Set<DatabaseObjectOption> options = new LinkedHashSet<>();

    public Set<Column> columns() {
        return Collections.unmodifiableSet(columns);
    }

    public CreateTable columns(Column... columns) {
        this.columns.addAll(asList(columns));
        return this;
    }

    @Override
    public CreateTable withOptions(DatabaseObjectOption... options) {
        this.options.addAll(Arrays.asList(options));
        return this;
    }

    @Override
    public Set<DatabaseObjectOption> options() {
        return Collections.unmodifiableSet(this.options);
    }

    public String getTableName() {
        return table.getName();
    }

    @Override
    public <T extends DatabaseObjectOption> Boolean contains(Class<T> option) {
        return HasOptions.$class.contains(this, option);
    }

    @Override
    public Boolean contains(String optionRepresentation) {
        return HasOptions.$class.contains(this, optionRepresentation);
    }

}
