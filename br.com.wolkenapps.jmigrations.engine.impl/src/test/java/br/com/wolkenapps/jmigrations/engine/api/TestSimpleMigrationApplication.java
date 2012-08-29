package br.com.wolkenapps.jmigrations.engine.api;

import static br.com.wolkenapps.jmigrations.dsl.Commands.*;
import static br.com.wolkenapps.jmigrations.dsl.Models.*;
import static br.com.wolkenapps.jmigrations.dsl.Types.*;
import lombok.experimental.ExtensionMethod;

import org.junit.Assert;
import org.junit.Test;

import br.com.wolkenapps.jmigrations.api.*;
import br.com.wolkenapps.jmigrations.dsl.extentions.Extensions;
import br.com.wolkenapps.jmigrations.model.domain.Table;

public class TestSimpleMigrationApplication {

    private static final String TABLE_FOR_TESTS = "test_123";

    @ExtensionMethod({ Extensions.Options_.class, Extensions.Columns_.class })
    private static class SimpleMigrationForTest implements Migration {

        @Override
        public DatabaseCommand[] up() {
            return new DatabaseCommand[] {
                    create(table(TABLE_FOR_TESTS).ifNotExists().columns("id".as(long_()),
                                                                        "other".as(string()).length(100),
                                                                        "other2".as(string()).notNull()))
            };
        }

        @Override
        public DatabaseCommand[] down() {
            return new DatabaseCommand[] {
                    drop(table(TABLE_FOR_TESTS)).ifExists().cascade()
            };
        }

    }

    // TODO inject
    private Database database = null; //new SimpleDatabase().with(new JdbcApplier());

    @Test
    public void testUpAnDownSimpleMigration() {
        SimpleMigrationForTest migration = new SimpleMigrationForTest();

        database.up(migration);
        Assert.assertTrue(database.contains(new Table(TABLE_FOR_TESTS)));

        database.down(migration);
        Assert.assertTrue(!database.contains(new Table(TABLE_FOR_TESTS)));
    }
}
