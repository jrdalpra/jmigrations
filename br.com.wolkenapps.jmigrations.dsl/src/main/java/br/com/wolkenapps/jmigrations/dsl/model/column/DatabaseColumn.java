package br.com.wolkenapps.jmigrations.dsl.model.column;

import static java.util.Arrays.asList;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import br.com.wolkenapps.jmigrations.dsl.model.column.options.DatabaseColumnOption;
import br.com.wolkenapps.jmigrations.dsl.model.column.types.DatabaseColumnType;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
public class DatabaseColumn {

    @Getter
    private final String              name;

    @Setter
    @Getter
    private DatabaseColumnType        type;

    private Set<DatabaseColumnOption> modifiers = new HashSet<>();

    public DatabaseColumn withOptions(DatabaseColumnOption... modifiers) {
        this.modifiers.addAll(asList(modifiers));
        return this;
    }

    public Set<DatabaseColumnOption> modifiers() {
        return Collections.unmodifiableSet(this.modifiers);
    }

    public DatabaseColumn type(DatabaseColumnType type) {
        setType(type);
        return this;
    }

}
