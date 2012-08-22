package br.com.wolkenapps.jmigrations.dsl;

import br.com.wolkenapps.jmigrations.dsl.model.column.Column;

public final class Models {

    private Models() {
    }

    public static Column column(String name) {
        return new Column(name);
    }

}
