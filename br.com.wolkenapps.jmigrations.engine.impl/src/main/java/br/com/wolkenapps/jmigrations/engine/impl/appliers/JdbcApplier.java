package br.com.wolkenapps.jmigrations.engine.impl.appliers;

import java.sql.Connection;

import lombok.SneakyThrows;
import br.com.wolkenapps.jmigrations.api.DatabaseCommand;
import br.com.wolkenapps.jmigrations.dsl.model.commands.CreateTable;
import br.com.wolkenapps.jmigrations.engine.api.internal.DatabaseCommandApplier;
import br.com.wolkenapps.jmigrations.engine.api.internal.Dialect;
import br.com.wolkenapps.jmigrations.engine.impl.dialects.SimpleDialect;

/**
 * Applies a {@link DatabaseCommand} over a {@link Connection}
 * 
 * @author jose.junior
 * 
 */
// @ManagedBean or @Component
public class JdbcApplier implements DatabaseCommandApplier {

    // @Inject
    private Connection database;

    // @Inject
    private Dialect    dialect = new SimpleDialect();

    @Override
    public boolean accepts(DatabaseCommand toBeApplied) {
        return toBeApplied != null && CreateTable.class.isInstance(toBeApplied);
    }

    @Override
    @SneakyThrows
    public <CommandType extends DatabaseCommand> void applies(CommandType toBeApplied) {
        System.out.println(dialect.producesDDLFor(toBeApplied));
        // database.prepareStatement(dialect.producesDDLFor(toBeApplied)).executeUpdate();
    }

}
