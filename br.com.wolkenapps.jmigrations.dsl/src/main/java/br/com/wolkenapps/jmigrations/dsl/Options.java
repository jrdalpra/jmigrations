package br.com.wolkenapps.jmigrations.dsl;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import br.com.wolkenapps.jmigrations.dsl.model.column.options.Length;
import br.com.wolkenapps.jmigrations.dsl.model.column.options.PrimaryKeyColumn;
import br.com.wolkenapps.jmigrations.dsl.model.commons.options.Cascade;
import br.com.wolkenapps.jmigrations.dsl.model.commons.options.IfExists;
import br.com.wolkenapps.jmigrations.dsl.model.commons.options.IfNotExists;
import br.com.wolkenapps.jmigrations.dsl.model.commons.options.NotNull;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Options {

    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public static class Commons {
        public static Cascade cascade() {
            return new Cascade();
        }

        public static IfExists ifExists() {
            return new IfExists();
        }

        public static NotNull notNull() {
            return new NotNull();
        }

        public static IfNotExists ifNotExists() {
            return new IfNotExists();
        }
    }

    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public static class Columns {
        public static Length length(Number length) {
            return new Length(length);
        }

        public static PrimaryKeyColumn primaryKeyColumn() {
            return new PrimaryKeyColumn();
        }
    }

}
