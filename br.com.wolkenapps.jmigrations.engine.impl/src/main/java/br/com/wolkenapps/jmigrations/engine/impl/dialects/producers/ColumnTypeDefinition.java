package br.com.wolkenapps.jmigrations.engine.impl.dialects.producers;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import br.com.wolkenapps.jmigrations.dsl.model.column.Column;
import br.com.wolkenapps.jmigrations.dsl.model.column.types.ColumnType;

@RequiredArgsConstructor
@Getter
public class ColumnTypeDefinition {

    private final Column     column;

    private final ColumnType type;

}
