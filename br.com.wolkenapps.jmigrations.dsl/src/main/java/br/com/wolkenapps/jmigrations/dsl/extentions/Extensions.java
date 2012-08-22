package br.com.wolkenapps.jmigrations.dsl.extentions;

import br.com.wolkenapps.jmigrations.dsl.Options;
import br.com.wolkenapps.jmigrations.dsl.model.column.Column;
import br.com.wolkenapps.jmigrations.dsl.model.column.types.ColumnType;
import br.com.wolkenapps.jmigrations.dsl.model.commons.stereotype.CanUseCascade;
import br.com.wolkenapps.jmigrations.dsl.model.commons.stereotype.CanUseIfExists;
import br.com.wolkenapps.jmigrations.dsl.model.commons.stereotype.CanUseIfNotExists;
import br.com.wolkenapps.jmigrations.dsl.model.commons.stereotype.CanUseNotNull;
import br.com.wolkenapps.jmigrations.dsl.model.commons.stereotype.HasOptions;

public class Extensions {

    public static class Commons {

        public static Column as(String name, ColumnType type) {
            return new Column(name).type(type);
        }

    }

    public static class Options_ {

        public static <T extends CanUseIfExists & HasOptions<T>> T ifExists(T self) {
            return self.withOptions(Options.Commons.ifExists());
        }
        
        public static <T extends CanUseIfNotExists & HasOptions<T>> T ifNotExists(T self) {
            return self.withOptions(Options.Commons.ifNotExists());
        }

        public static <T extends CanUseCascade & HasOptions<T>> T cascade(T self) {
            return self.withOptions(Options.Commons.cascade());
        }

        public static <T extends CanUseNotNull & HasOptions<T>> T notNull(T self) {
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
