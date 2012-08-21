package br.com.wolkenapps.jmigrations.dsl.model.column.options;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Length implements DatabaseColumnOption {

    @Getter
    private final Number length;

}
