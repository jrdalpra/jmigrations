package br.com.wolkenapps.jmigrations.dsl.model.table;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import br.com.wolkenapps.jmigrations.dsl.model.DatabaseObject;

@RequiredArgsConstructor
public class Table implements DatabaseObject {

    @Getter
    private final String name;

    public Table() {
        this(null);
    }

}
