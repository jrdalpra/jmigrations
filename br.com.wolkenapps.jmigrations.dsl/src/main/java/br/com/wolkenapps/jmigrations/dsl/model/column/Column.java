package br.com.wolkenapps.jmigrations.dsl.model.column;

import static java.util.Arrays.asList;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import br.com.wolkenapps.jmigrations.dsl.model.column.types.ColumnType;
import br.com.wolkenapps.jmigrations.dsl.model.commons.options.DatabaseObjectOption;
import br.com.wolkenapps.jmigrations.dsl.model.commons.stereotype.CanUseNotNull;
import br.com.wolkenapps.jmigrations.dsl.model.commons.stereotype.HasOptions;

@RequiredArgsConstructor
public class Column implements HasOptions<Column>, CanUseNotNull {

    @Getter
    private final String              name;

    @Setter
    @Getter
    private ColumnType                type;

    private Set<DatabaseObjectOption> options = new HashSet<>();

    public Column withOptions(DatabaseObjectOption... options) {
        this.options.addAll(asList(options));
        return this;
    }

    public Column type(ColumnType type) {
        setType(type);
        return this;
    }

    @Override
    public Set<DatabaseObjectOption> options() {
        return Collections.unmodifiableSet(this.options);
    }

    @Override
    public <T extends DatabaseObjectOption> Boolean contains(Class<T> option) {
        return HasOptions.$class.contains(this, option);
    }

    @Override
    public Boolean contains(String optionRepresentation) {
        return HasOptions.$class.contains(this, optionRepresentation);
    }
}
