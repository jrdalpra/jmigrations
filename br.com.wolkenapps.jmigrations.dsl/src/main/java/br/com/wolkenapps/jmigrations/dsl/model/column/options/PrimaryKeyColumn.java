package br.com.wolkenapps.jmigrations.dsl.model.column.options;

import lombok.RequiredArgsConstructor;
import br.com.wolkenapps.jmigrations.dsl.model.commons.options.DatabaseObjectOption;

@RequiredArgsConstructor
public class PrimaryKeyColumn implements DatabaseObjectOption {

    @Override
    public String representation() {
        return "primarykey";
    }

}
