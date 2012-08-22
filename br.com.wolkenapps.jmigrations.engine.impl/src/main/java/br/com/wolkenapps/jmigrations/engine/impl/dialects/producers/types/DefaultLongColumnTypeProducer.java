package br.com.wolkenapps.jmigrations.engine.impl.dialects.producers.types;

import br.com.wolkenapps.jmigrations.dsl.model.column.Column;
import br.com.wolkenapps.jmigrations.dsl.model.column.types.LongColumnType;
import br.com.wolkenapps.jmigrations.engine.impl.dialects.producers.DataDefinitionProducer;

public class DefaultLongColumnTypeProducer implements DataDefinitionProducer<DefaultLongColumnTypeProducer, Column> {

    @Override
    public Boolean accepts(Column something) {
        return something != null &&
               something.getType() != null &&
               LongColumnType.class.isInstance(something.getType());
    }

    @Override
    public String producesDDLFor(Column something) {
        return "bigint";
    }

}
