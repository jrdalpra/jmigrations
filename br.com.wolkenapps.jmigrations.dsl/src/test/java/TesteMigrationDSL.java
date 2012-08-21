import static br.com.wolkenapps.jmigrations.dsl.Commands.*;
import static br.com.wolkenapps.jmigrations.dsl.Models.*;
import static br.com.wolkenapps.jmigrations.dsl.Options.*;
import static br.com.wolkenapps.jmigrations.dsl.Options.DropTableOptions.*;
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
                    createTable("user").columns(column("id").type(long_()).withOptions(notNull(), primaryKey()),
                                                column("login").type(string()).withOptions(notNull(), length(100)),
                                                column("passwd").type(string()).withOptions(notNull()))
            };
        }

        @Override
        public DatabaseCommand[] down() {
            return new DatabaseCommand[] {
                    dropTable("user").withOptions(ifExists(), cascade())
            };
        }
    }

    @ExtensionMethod({ Extensions.Commons.class, Extensions.Options_.class, Extensions.DropTable_.class })
    private static class TesteMigrationWithExtensionMethods implements Migration {

        @Override
        public DatabaseCommand[] up() {
            return new DatabaseCommand[] {
                    createTable("user").columns("id".as(long_()).notNull(),
                                                "login".as(string()).notNull().length(100),
                                                "passwd".as(string()).notNull())
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
