package br.com.wolkenapps.jmigrations.engine.impl.dialects.producers;

import java.util.*;

import br.com.wolkenapps.jmigrations.dsl.model.column.Column;
import br.com.wolkenapps.jmigrations.engine.impl.dialects.producers.types.DefaultLongColumnTypeProducer;
import br.com.wolkenapps.jmigrations.engine.impl.dialects.producers.types.DefaultStringColumnTypeProducer;

public class GenericColumnDataDefinitionProducer implements DataDefinitionProducer<GenericColumnDataDefinitionProducer, Column> {

    private Set<DataDefinitionProducer<?, Column>> columnTypeProducers = new HashSet<>(Arrays.<DataDefinitionProducer<?, Column>> asList(new DefaultLongColumnTypeProducer(),
                                                                                                                                         new DefaultStringColumnTypeProducer()));

    @Override
    public Boolean accepts(Column something) {
        return something != null;
    }

    @Override
    public String producesDDLFor(Column something) {
        boolean hasFoundProducerForType = false;
        StringBuilder ddl = new StringBuilder();

        ddl.append(something.getName());
        ddl.append(" ");

        type_loop:
        for (DataDefinitionProducer<?, Column> columnTypeProducer : columnTypeProducers) {
            if (columnTypeProducer.accepts(something)) {
                ddl.append(columnTypeProducer.producesDDLFor(something));
                hasFoundProducerForType = true;
                break type_loop;
            }
        }

        if (!hasFoundProducerForType) {
            throw new RuntimeException("Type " + something.getType() + " has no producer!");
        }

        return ddl.toString();
    }

}
