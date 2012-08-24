import static br.com.wolkenapps.jmigrations.dsl.AlterActions.*;
import static br.com.wolkenapps.jmigrations.dsl.Commands.*;
import static br.com.wolkenapps.jmigrations.dsl.Models.*;
import static br.com.wolkenapps.jmigrations.dsl.Options.Columns.*;
import static br.com.wolkenapps.jmigrations.dsl.Options.Commons.*;
import static br.com.wolkenapps.jmigrations.dsl.Options.Tables.*;
import static br.com.wolkenapps.jmigrations.dsl.Types.*;
import lombok.experimental.ExtensionMethod;
import br.com.wolkenapps.jmigrations.api.*;
import br.com.wolkenapps.jmigrations.dsl.extentions.Extensions;

public class IdeasForMigrationDSL {

    private static class TesteMigration implements Migration {

        @Override
        public DatabaseCommand[] up() {
            return new DatabaseCommand[] {
                    create(table("user").columns(column("id").type(long_()).notNull(),
                                                 column("login").type(string()).withOptions(notNull(), length(100)),
                                                 column("passwd").type(string()).withOptions(notNull(), length(20)))).ifNotExists()
            };
        }

        @Override
        public DatabaseCommand[] down() {
            return new DatabaseCommand[] {
                    drop(table("user")).ifExists().cascade()
            };
        }
    }

    @ExtensionMethod({ Extensions.Columns_.class, Extensions.Options_.class })
    private static class TesteMigrationWithExtensionMethods implements RestrictedMigration {

        public boolean canBeAppliedOn(Database target) {
            return target.url().contains("oracle"); // to restrict the enviroment
        }

        @Override
        public DatabaseCommand[] up() {
            return new DatabaseCommand[] {
                    create(table("user").columns("id".as(long_()).notNull().asPrimaryKey(),
                                                 "login".as(string()).notNull().length(100),
                                                 "passwd".as(string()).notNull().length(20))).ifNotExists()
            };
        }

        @Override
        public DatabaseCommand[] down() {
            return new DatabaseCommand[] {
                    drop(table("user")).ifExists().cascade()
            };
        }
    }

    public static void main(String[] args) {
        // TODO data manipulation dsl
        // update("user").set("login", "teste").where("id", Is.equals(10)).and("login", Is.equals("x"));
        // update("user").set("login", "teste").where("id", Is.greaterThan(10));
        // update("user").set("senha", "").where("id", Is.in()); // ??

        // TODO think: a migration is unique by data / time / user ... but we can have several date/time locales
        // or diferente migration's name conventions ... 
        // CreateUsers_20120823_115023_jrdalpra and
        // CreateUsers_23082012_115023_jrdalpra are de same migration
        
        /* TODO create variations */
        create(table("user").columns(column("id").type(long_())));
        create(table("partner").columns(column("id").type(long_()).asPrimaryKey(),
                                        column("name").type(string()).length(100))
                                        .primaryKey("id")).ifNotExists();
        create(index("idx_user_id").on("user").column("id"));
        create(index("idx_user_id_login").on("user").columns("id", "login"));
        create(index("idx_user_id_login").unique().on("user").columns("id", "login"));
        create(sequence("seq_users").startWith(1).incrementBy(1).maxValue(999999));


        /* TODO drop variations */
        drop(sequence("seq_users")).ifExists();

        
        /* TODO alter variations * */
        alter(table("users"), drop(column("id")));
        alter(table("users"), drop(primaryKey("id")));
        alter(table("users"), drop(index("idx_users_login")));

        alter(table("users"), add(column("id").type(string())));
        alter(table("users"), add(primaryKey("id")));
        alter(table("users"), add(index("idx_test").unique().columns("c1","c2")));
        
        alter(table("users"), change(column("login").type(long_())));

        alter(table("users"), rename(column("login"), column("user")));
        alter(table("users"), renameSelfTo("user"));
        alter(table("users"), renameColumnFromTo("login", "user"));
        
        alter(sequence("seq_users"), renameSelfTo("seq_user"));


        DatabaseCommand[] commands = new TesteMigration().up();

        for (DatabaseCommand command : commands) {
            System.out.println(command);
        }

    }
}
