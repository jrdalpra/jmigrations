package br.com.wolkenapps.jmigrations.engine.impl.dialects.producers;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import br.com.wolkenapps.jmigrations.api.DatabaseCommand;
import br.com.wolkenapps.jmigrations.dsl.model.column.Column;
import br.com.wolkenapps.jmigrations.dsl.model.commands.CreateTable;
import br.com.wolkenapps.jmigrations.dsl.model.commons.options.DatabaseObjectOption;

// TODO cdi
public class GenericCreateTableDataDefinitionProducer implements DataDefinitionProducer<GenericCreateTableDataDefinitionProducer, DatabaseCommand> {

    // TODO cdi
    private Set<DataDefinitionProducer<?, Column>> columnsProducers = new HashSet<>(Arrays.<DataDefinitionProducer<?, Column>> asList(new GenericColumnDataDefinitionProducer()));

    @Override
    public Boolean accepts(DatabaseCommand something) {
        return something != null && CreateTable.class.isInstance(something);
    }

    @Override
    public String producesDDLFor(DatabaseCommand something) {

        CreateTable create = CreateTable.class.cast(something);

        StringBuilder ddl = new StringBuilder();

        ddl.append(createTableStatement()).append(" ");
        ddl.append(create.getTableName());
        
        ddl.append(startColumnsMark());
        
        appendOnDDLColumns(ddl, create.columns());
        
        ddl.append(endColumnsMark());

        appendOnDDLOptions(ddl, create.options());

        return ddl.toString();
    }

    protected String createTableStatement() {
        return "create table";
    }

    protected String startColumnsMark() {
        return " ( ";
    }

    protected String endColumnsMark() {
        return " ) ";
    }

    protected void appendOnDDLOptions(StringBuilder ddl, Set<DatabaseObjectOption> options) {

    }

    protected void appendOnDDLColumns(StringBuilder ddl, Set<Column> columns) {
        int count = 0;
        boolean hasFoundProducer = false;
        for (Column column : columns) {
            for (DataDefinitionProducer<?, Column> producer : columnsProducers) {
                hasFoundProducer = false;
                if (producer.accepts(column)) {
                    ddl.append(producer.producesDDLFor(column));
                    hasFoundProducer = true;
                }
                if (!hasFoundProducer) {
                    throw new RuntimeException("Column Type " + column.getType() + " has no producer!");
                }
                count++;
                if (count < columns.size()) {
                    ddl.append(separatorForColumns());
                }
            }
        }
    }

    protected String separatorForColumns() {
        return ", ";
    }
}
