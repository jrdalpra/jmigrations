package br.com.wolkenapps.jmigrations.dsl.extentions;

import br.com.wolkenapps.jmigrations.dsl.Options;
import br.com.wolkenapps.jmigrations.dsl.model.column.DatabaseColumn;
import br.com.wolkenapps.jmigrations.dsl.model.column.types.DatabaseColumnType;
import br.com.wolkenapps.jmigrations.dsl.model.commands.DropTable;

public class Extensions {

    public static class Commons {

        public static DatabaseColumn as(String name, DatabaseColumnType type) {
            return new DatabaseColumn(name).type(type);
        }

    }

    public static class Options_ {
        public static DatabaseColumn notNull(DatabaseColumn column) {
            return column.withOptions(Options.notNull());
        }

        public static DatabaseColumn length(DatabaseColumn column, Number length) {
            return column.withOptions(Options.length(length));
        }

    }

    public static class DropTable_ {

        public static DropTable ifExists(DropTable command) {
            return command.withOptions(Options.DropTableOptions.ifExists());
        }

        public static DropTable cascade(DropTable command) {
            return command.withOptions(Options.DropTableOptions.cascade());
        }

    }

}
