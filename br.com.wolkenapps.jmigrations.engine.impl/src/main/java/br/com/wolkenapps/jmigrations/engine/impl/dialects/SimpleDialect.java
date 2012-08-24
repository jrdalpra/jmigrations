package br.com.wolkenapps.jmigrations.engine.impl.dialects;

import java.util.*;

import br.com.wolkenapps.jmigrations.api.DatabaseCommand;
import br.com.wolkenapps.jmigrations.engine.api.internal.Dialect;
import br.com.wolkenapps.jmigrations.engine.impl.dialects.producers.DataDefinitionProducer;
import br.com.wolkenapps.jmigrations.engine.impl.dialects.producers.GenericCreateTableDataDefinitionProducer;

// TODO cdi
public class SimpleDialect implements Dialect {

    // TODO cdi
    private Set<DataDefinitionProducer<?, DatabaseCommand>> producers = new HashSet<>(Arrays.<DataDefinitionProducer<?, DatabaseCommand>> asList(new GenericCreateTableDataDefinitionProducer()));

    @Override
    public String producesDDLFor(DatabaseCommand command) {
        for (DataDefinitionProducer<?, DatabaseCommand> producer : producers) {
            if (producer.accepts(command)) {
                return producer.producesDDLFor(command);
            }
        }
        throw new RuntimeException("No DDL Producer found for " + command);
    }

}
