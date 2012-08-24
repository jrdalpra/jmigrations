package br.com.wolkenapps.jmigrations.dsl;

import br.com.wolkenapps.jmigrations.model.domain.*;

public final class Models {

    private Models() {
    }

    public static Table table(String name) {
        return new Table(name);
    }

    public static Index index(String name) {
        return new Index(name);
    }

    public static Sequence sequence(String name) {
        return new Sequence(name);
    }

    public static Column column(String name) {
        return new Column(name);
    }

    public static IndexColumn indexColumn(String name) {
        return new IndexColumn(name);
    }

}
