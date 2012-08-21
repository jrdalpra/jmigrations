package br.com.wolkenapps.jmigrations.dsl;

import br.com.wolkenapps.jmigrations.dsl.model.commands.CreateTable;
import br.com.wolkenapps.jmigrations.dsl.model.commands.DropTable;

public final class Commands {

    private Commands() {
    }

    public static CreateTable createTable(String name) {
        return new CreateTable(name);
    }

    public static DropTable dropTable(String name) {
        return new DropTable(name);
    }

}
