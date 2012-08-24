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

    private static class TestMigration implements Migration {

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
    private static class TestMigrationWithExtensionMethods implements RestrictedMigration {

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

        create(table("partner").columns(column("id").type(long_()),
                                        column("name").type(string()).length(100))
                               .primaryKey("id")).ifNotExists();

        create(table("partner").columns(column("id").type(long_()).asPrimaryKey(),
                                        column("name").type(string()).length(100),
                                        column("type_id").type(long_())
                                                         .foreignKey("fk_partner_type",
                                                                     references(table("type").column("id"))))).ifNotExists();
        // same, but with a different approach
        ifNotExists(create(table("partner").columns(column("id").type(long_()).asPrimaryKey(),
                                                    column("name").type(string()).length(100))));

        create(table("some_table").column(column("id").type(long_()))
                                  .foreignKey("fk_some_fk", columns("column_1", "column_2"), references(table("other_table").column("other_table_column")))
                                  .foreignKey("other_fk", column("id"), references(table("yet_another_table").column("column_x"))));

        create(index("idx_user_id").on("user").column("id"));

        create(index("idx_user_id_login").on("user").columns("id", "login"));

        create(index("idx_user_id_login").unique().on("user").columns("id", "login"));

        create(sequence("seq_users").startWith(1).incrementBy(1).maxValue(999999));
        
        create(foreignKey("fk_teste").table("some_table").column("id").references(table("other_table").column("column_x")));
        

        /* TODO drop variations */
        drop(sequence("seq_users")).ifExists();
        drop(table("user")).ifExists();
        ifExists(drop(table("user"))); // same as drop(table("user")).ifExists();
        drop(index("idx_some_index")).ifExists();
        drop(foreignKey("fk_some_fk")).ifExists();
        
        /* TODO alter variations * */
        alter(table("user"), drop(column("id")));
        alter(table("user"), drop(primaryKey("id")));
        alter(table("user"), drop(index("idx_users_login")));

        alter(table("user"), add(column("id").type(string())));
        alter(table("user"), add(primaryKey("id")));
        alter(table("user"), add(index("idx_test").unique().columns("c1", "c2")));
        alter(table("user"), add(foreignKey("fk_company").references(table("company").column("id"))));
        
        alter(table("user"), change(column("login").type(long_())));

        alter(table("user"), rename(column("login"), column("user")));
        alter(table("user"), renameSelfTo("user_old"));
        alter(table("user"), renameColumnFromTo("login", "user"));

        alter(sequence("seq_users"), renameSelfTo("seq_user"));

        alter(index("idx_useful"), renameSelfTo("idx_not_so_useful"));

        DatabaseCommand[] commands = new TestMigration().up();

        for (DatabaseCommand command : commands) {
            System.out.println(command);
        }

    }
}
