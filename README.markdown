jmigrations
===========

Full Java Migrations Framework - inspired on Rails Migration

#Features planned

- 100% Java DSL
- Modularized
  - API 
  - DSL
  - CORE
  - Standalone
  - Maven
  - Ant
  - Gradle
- Extensible 
- DRY - use all Java tools and frameworks that already exists
- Can be used standalone - non Java projects can takes advantage of this

Example

	public class CreateUserTable_21082012_1117_jrdalpra implements Migration {		

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
                    dropTable("user")
            };
        }
    }

Or using lombok extension methods

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

# We are accepting more features



[![Bitdeli Badge](https://d2weczhvl823v0.cloudfront.net/jrdalpra/jmigrations/trend.png)](https://bitdeli.com/free "Bitdeli Badge")

