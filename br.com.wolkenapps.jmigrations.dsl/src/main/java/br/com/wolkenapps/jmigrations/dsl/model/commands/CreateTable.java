package br.com.wolkenapps.jmigrations.dsl.model.commands;

import static java.util.Arrays.asList;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import lombok.Getter;
import br.com.wolkenapps.jmigrations.api.DatabaseCommand;
import br.com.wolkenapps.jmigrations.dsl.model.column.DatabaseColumn;
import br.com.wolkenapps.jmigrations.dsl.model.table.Table;

public class CreateTable implements DatabaseCommand {

    @Getter
    private final Table table;

    public CreateTable(String name) {
        this.table = new Table(name);
    }

    private Set<DatabaseColumn> columns = new HashSet<>();

    public Set<DatabaseColumn> columns() {
        return Collections.unmodifiableSet(columns);
    }

    public CreateTable columns(DatabaseColumn... columns) {
        this.columns.addAll(asList(columns));
        return this;
    }

}
