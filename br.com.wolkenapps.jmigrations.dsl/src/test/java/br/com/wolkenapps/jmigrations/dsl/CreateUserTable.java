package br.com.wolkenapps.jmigrations.dsl;

import static br.com.wolkenapps.jmigrations.dsl.AlterActions.*;
import static br.com.wolkenapps.jmigrations.dsl.Commands.*;
import static br.com.wolkenapps.jmigrations.dsl.Models.*;
import static br.com.wolkenapps.jmigrations.dsl.Options.Columns.*;
import static br.com.wolkenapps.jmigrations.dsl.Options.Commons.*;
import static br.com.wolkenapps.jmigrations.dsl.Options.Tables.*;
import static br.com.wolkenapps.jmigrations.dsl.Options.Sequences.*;
import static br.com.wolkenapps.jmigrations.dsl.Types.*;

import br.com.wolkenapps.jmigrations.api.DatabaseCommand;
import br.com.wolkenapps.jmigrations.api.Migration;

@SuppressWarnings("unused")
public class CreateUserTable implements Migration {

    @Override
    public DatabaseCommand[] up() {
        return new DatabaseCommand[] {
                create(table("user").columns(column("id").type(long_()).asPrimaryKey(),
                                             column("login").type(string()).notNull().length(100),
                                             column("password").type(string()).notNull().length(20)))
        };
    }

    @Override
    public DatabaseCommand[] down() {
        return new DatabaseCommand[] {
                drop(table("users"))
        };
    }
}
