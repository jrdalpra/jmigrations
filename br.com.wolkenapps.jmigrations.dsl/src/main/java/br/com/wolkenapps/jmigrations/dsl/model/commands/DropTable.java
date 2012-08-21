package br.com.wolkenapps.jmigrations.dsl.model.commands;

import lombok.Getter;
import br.com.wolkenapps.jmigrations.api.DatabaseCommand;
import br.com.wolkenapps.jmigrations.dsl.model.table.Table;

public class DropTable implements DatabaseCommand {

    @Getter
    private final Table table;

    public DropTable(String name) {
        this.table = new Table(name);
    }

}
