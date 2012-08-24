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
public class InsertIntoMigration implements Migration {

    @Override
    public DatabaseCommand[] up() {
        return new DatabaseCommand[] {
                insertInto("user").columns("id", "login", "password").values(1, "admin", "admin"),
                insertInto(table("user")).columns("id", "login", "password").values(2, "user", "user"),
                insertInto("user").values(3, "other", "other"), // all columns insert
                create(sequence("seq_users").startWith(4))
        };
    }

    @Override
    public DatabaseCommand[] down() {
        // TODO waiting for delete command :)
        return null;
    }

}
