import static br.com.wolkenapps.jmigrations.dsl.Commands.createTable;
import static br.com.wolkenapps.jmigrations.dsl.Commands.dropTable;
import static br.com.wolkenapps.jmigrations.dsl.Models.column;
import static br.com.wolkenapps.jmigrations.dsl.Options.Columns.length;
import static br.com.wolkenapps.jmigrations.dsl.Options.Columns.primaryKeyColumn;
import static br.com.wolkenapps.jmigrations.dsl.Options.Commons.cascade;
import static br.com.wolkenapps.jmigrations.dsl.Options.Commons.ifExists;
import static br.com.wolkenapps.jmigrations.dsl.Options.Commons.notNull;
import static br.com.wolkenapps.jmigrations.dsl.Types.long_;
import static br.com.wolkenapps.jmigrations.dsl.Types.string;
import lombok.experimental.ExtensionMethod;
import br.com.wolkenapps.jmigrations.api.DatabaseCommand;
import br.com.wolkenapps.jmigrations.api.Migration;
import br.com.wolkenapps.jmigrations.dsl.extentions.Extensions;

public class TesteMigrationDSL {

    private static class TesteMigration implements Migration {

        @Override
        public DatabaseCommand[] up() {
            return new DatabaseCommand[] {
                    createTable("user").columns(column("id").type(long_()).withOptions(notNull(), primaryKeyColumn()),
                                                column("login").type(string()).withOptions(notNull(), length(100)),
                                                column("passwd").type(string()).withOptions(notNull(), length(20)))
            };
        }

        @Override
        public DatabaseCommand[] down() {
            return new DatabaseCommand[] {
                    dropTable("user").withOptions(ifExists(), cascade())
            };
        }
    }

    @ExtensionMethod({ Extensions.Commons.class, Extensions.Options_.class })
    private static class TesteMigrationWithExtensionMethods implements Migration {

        @Override
        public DatabaseCommand[] up() {
            return new DatabaseCommand[] {
                    createTable("user").ifNotExists().columns("id".as(long_()).notNull().primaryKey(),
                                                              "login".as(string()).notNull().length(100),
                                                              "passwd".as(string()).notNull().length(20))
            };
        }

        @Override
        public DatabaseCommand[] down() {
            return new DatabaseCommand[] {
                    dropTable("user").ifExists().cascade()
            };
        }
    }

    public static void main(String[] args) {

        DatabaseCommand[] commands = new TesteMigration().up();

        for (DatabaseCommand command : commands) {
            System.out.println(command);
        }

    }
}
