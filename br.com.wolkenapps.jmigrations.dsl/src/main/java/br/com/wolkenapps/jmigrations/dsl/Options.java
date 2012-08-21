package br.com.wolkenapps.jmigrations.dsl;

import br.com.wolkenapps.jmigrations.dsl.model.column.options.Length;
import br.com.wolkenapps.jmigrations.dsl.model.column.options.NotNull;
import br.com.wolkenapps.jmigrations.dsl.model.column.options.PrimaryKey;

public class Options {

    private Options() {
    }

    public static NotNull notNull() {
        return new NotNull();
    }

    public static Length length(Number length) {
        return new Length(length);
    }

    public static PrimaryKey primaryKey() {
        return new PrimaryKey();
    }

}
