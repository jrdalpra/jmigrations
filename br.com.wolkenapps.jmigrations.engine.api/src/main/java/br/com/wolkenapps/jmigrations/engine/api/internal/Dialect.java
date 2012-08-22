package br.com.wolkenapps.jmigrations.engine.api.internal;

import br.com.wolkenapps.jmigrations.api.DatabaseCommand;

/**
 * Responsable to create the DDL for {@link DatabaseCommand}s
 * 
 * @author jose.junior
 * 
 */
public interface Dialect {

    String producesDDLFor(DatabaseCommand command);

}
