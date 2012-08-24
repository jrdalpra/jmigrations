package br.com.wolkenapps.jmigrations.dsl;

import java.util.Arrays;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.experimental.ExtensionMethod;
import br.com.wolkenapps.jmigrations.model.commons.options.*;
import br.com.wolkenapps.jmigrations.model.commons.stereotype.HasOptions;
import br.com.wolkenapps.jmigrations.model.domain.Column;
import br.com.wolkenapps.jmigrations.model.domain.Table;
import br.com.wolkenapps.jmigrations.model.domain.columns.options.Length;
import br.com.wolkenapps.jmigrations.model.domain.columns.options.NotNull;
import br.com.wolkenapps.jmigrations.model.domain.foreignkeys.options.References;

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

        /**
         * Just puts the {@link IfExists} option on it
         * 
         * @param self
         * @return self
         */
        public static <Self extends HasOptions<Self>> Self ifExists(Self self) {
            return self.withOptions(ifExists());
        }

        public static NotNull notNull() {
            return new NotNull();
        }

        public static IfNotExists ifNotExists() {
            return new IfNotExists();
        }

        /**
         * Just puts the {@link IfNotExists} option on it
         * 
         * @param self
         * @return self
         */
        public static <Self extends HasOptions<Self>> Self ifNotExists(Self self) {
            return self.withOptions(ifNotExists());
        }

    }

    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public static class Columns {
        public static Length length(Number length) {
            return new Length(length);
        }

        public static PrimaryKey primaryKeyColumn() {
            return new PrimaryKey();
        }

        public static References references(Table otherSide) {
            return new References(otherSide);
        }
    }

    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    @ExtensionMethod({ Arrays.class })
    public static class Tables {

        public static PrimaryKey primaryKey(Column... columns) {
            return new PrimaryKey(columns.asList());
        }

        public static PrimaryKey primaryKey(String... columns) {
            return new PrimaryKey(columns);
        }
    }

}
