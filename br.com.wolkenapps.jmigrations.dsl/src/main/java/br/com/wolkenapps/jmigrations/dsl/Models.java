package br.com.wolkenapps.jmigrations.dsl;

import br.com.wolkenapps.jmigrations.dsl.model.column.DatabaseColumn;

public final class Models {

    private Models() {
    }

    public static DatabaseColumn column(String name) {
        return new DatabaseColumn(name);
    }

}
