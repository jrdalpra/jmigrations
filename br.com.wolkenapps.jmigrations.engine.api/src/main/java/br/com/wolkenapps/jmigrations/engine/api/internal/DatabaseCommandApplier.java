package br.com.wolkenapps.jmigrations.engine.api.internal;

import br.com.wolkenapps.jmigrations.api.DatabaseCommand;

/**
 * Who applies the {@link DatabaseCommand}
 * 
 * @author jose.junior
 * 
 */
public interface DatabaseCommandApplier {

    boolean accepts(DatabaseCommand toBeApplied);

    <CommandType extends DatabaseCommand> void applies(CommandType toBeApplied);

}
