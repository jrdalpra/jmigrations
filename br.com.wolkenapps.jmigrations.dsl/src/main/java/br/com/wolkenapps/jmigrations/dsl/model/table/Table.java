package br.com.wolkenapps.jmigrations.dsl.model.table;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import br.com.wolkenapps.jmigrations.dsl.model.table.options.TableOption;

@RequiredArgsConstructor
public class Table {

    @Getter
    private final String     name;

    private Set<TableOption> options = new HashSet<>();

    public Table withOptions(TableOption... options) {
        this.options.addAll(Arrays.asList(options));
        return this;
    }

}
