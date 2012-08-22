package br.com.wolkenapps.jmigrations.dsl;

import br.com.wolkenapps.jmigrations.dsl.model.column.types.LongColumnType;
import br.com.wolkenapps.jmigrations.dsl.model.column.types.StringColumnType;

public class Types {

    private Types() {
    }

    public static StringColumnType string() {
        return new StringColumnType();
    }
    
    public static LongColumnType long_(){
        return new LongColumnType();
    }

}
