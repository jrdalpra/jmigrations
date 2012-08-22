package br.com.wolkenapps.jmigrations.engine.impl.dialects.producers.types;

import java.util.*;

import br.com.wolkenapps.jmigrations.dsl.model.column.Column;
import br.com.wolkenapps.jmigrations.dsl.model.column.options.Length;
import br.com.wolkenapps.jmigrations.dsl.model.column.types.StringColumnType;
import br.com.wolkenapps.jmigrations.dsl.model.commons.options.DatabaseObjectOption;
import br.com.wolkenapps.jmigrations.dsl.model.commons.stereotype.HasOptions;
import br.com.wolkenapps.jmigrations.engine.impl.dialects.producers.DataDefinitionProducer;

public class DefaultStringColumnTypeProducer implements DataDefinitionProducer<DefaultStringColumnTypeProducer, Column> {

    private interface OptionApplier<Target extends HasOptions<Target>> {
        boolean accepts(Target target, DatabaseObjectOption option);

        void applies(StringBuilder ddl, Target target, DatabaseObjectOption option);
    }

    private class LengthOptionApplier implements OptionApplier<Column> {

        @Override
        public boolean accepts(Column target, DatabaseObjectOption option) {
            return option != null && Length.class.isInstance(option);
        }

        @Override
        public void applies(StringBuilder ddl, Column target, DatabaseObjectOption option) {
            ddl.append("(").append(Length.class.cast(option).getLength()).append(")");
        }

    }
    
    private Set<OptionApplier<Column>> appliers = new HashSet<>(Arrays.<OptionApplier<Column>> asList(new LengthOptionApplier()));

    @Override
    public Boolean accepts(Column something) {
        return something != null && something.getType() != null && StringColumnType.class.isInstance(something.getType());
    }


    @Override
    public String producesDDLFor(Column something) {

        StringBuilder ddl = new StringBuilder();
        ddl.append("varchar");

        Set<DatabaseObjectOption> options = something.options();

        to_next_option:
        for (DatabaseObjectOption option : options) {
            for (OptionApplier<Column> applier : appliers) {
                if (applier.accepts(something, option)) {
                    applier.applies(ddl, something, option);
                    continue to_next_option;
                }
            }
        }

        return ddl.toString();
    }
}
