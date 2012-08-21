package br.com.wolkenapps.jmigrations.dsl;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import br.com.wolkenapps.jmigrations.dsl.model.column.options.Length;
import br.com.wolkenapps.jmigrations.dsl.model.column.options.NotNull;
import br.com.wolkenapps.jmigrations.dsl.model.column.options.PrimaryKey;
import br.com.wolkenapps.jmigrations.dsl.model.commands.options.droptable.Cascade;
import br.com.wolkenapps.jmigrations.dsl.model.commands.options.droptable.IfExists;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Options {

    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public static final class DropTableOptions {

        public static IfExists ifExists() {
            return new IfExists();
        }

        public static Cascade cascade() {
            return new Cascade();
        }

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
