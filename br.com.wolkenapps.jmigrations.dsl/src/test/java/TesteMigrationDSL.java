import static br.com.wolkenapps.jmigrations.dsl.Commands.*;
import static br.com.wolkenapps.jmigrations.dsl.Models.column;
import static br.com.wolkenapps.jmigrations.dsl.Options.length;
import static br.com.wolkenapps.jmigrations.dsl.Options.*;
import static br.com.wolkenapps.jmigrations.dsl.Types.long_;
import static br.com.wolkenapps.jmigrations.dsl.Types.string;
import br.com.wolkenapps.jmigrations.api.DatabaseCommand;
import br.com.wolkenapps.jmigrations.api.Migration;

public class TesteMigrationDSL {

    private static class TesteMigration implements Migration {

        @Override
        public DatabaseCommand[] up() {
            return new DatabaseCommand[] {
                    createTable("usuario").columns(column("id").type(long_()).withOptions(notNull(), primaryKey()),
                                                   column("login").type(string()).withOptions(notNull(), length(100)),
                                                   column("senha").type(string()).withOptions(notNull()))
            };
        }

        @Override
        public DatabaseCommand[] down() {
            return new DatabaseCommand[] {
                    dropTable("usuario")
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
