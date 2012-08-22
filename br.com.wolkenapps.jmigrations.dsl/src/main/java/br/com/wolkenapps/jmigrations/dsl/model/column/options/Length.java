package br.com.wolkenapps.jmigrations.dsl.model.column.options;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import br.com.wolkenapps.jmigrations.dsl.model.commons.options.DatabaseObjectOption;

@RequiredArgsConstructor
public class Length implements DatabaseObjectOption {

    @Getter
    private final Number length;

    @Override
    public String representation() {
        return Length.class.getSimpleName().toLowerCase();
    }

}
