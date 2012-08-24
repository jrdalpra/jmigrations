package br.com.wolkenapps.jmigrations.dsl.extentions;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import br.com.wolkenapps.jmigrations.dsl.Options;
import br.com.wolkenapps.jmigrations.model.commons.stereotype.HasOptions;
import br.com.wolkenapps.jmigrations.model.domain.Column;
import br.com.wolkenapps.jmigrations.model.domain.DataType;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class Extensions {

    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public static final class Columns_ {

        public static Column as(String name, DataType type) {
            return new Column(name).type(type);
        }

    }

    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public static final class Options_ {
        public static <Self extends HasOptions<Self>> Self ifNotExists(Self self) {
            return self.withOptions(Options.Commons.ifNotExists());
        }

        public static <Self extends HasOptions<Self>> Self ifExists(Self self) {
            return self.withOptions(Options.Commons.ifExists());
        }

        public static <Self extends HasOptions<Self>> Self cascade(Self self) {
            return self.withOptions(Options.Commons.cascade());
        }

        public static <Self extends HasOptions<Self>> Self notNull(Self self) {
            return self.withOptions(Options.Commons.notNull());
        }

        public static Column length(Column self, Number length) {
            return self.withOptions(Options.Columns.length(length));
        }

        public static Column primaryKey(Column self) {
            return self.withOptions(Options.Columns.primaryKeyColumn());
        }
    }

}
