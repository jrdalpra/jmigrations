package br.com.wolkenapps.jmigrations.dsl;

import br.com.wolkenapps.jmigrations.dsl.model.column.types.LongType;
import br.com.wolkenapps.jmigrations.dsl.model.column.types.StringType;

public class Types {

    private Types() {
    }

    public static StringType string() {
        return new StringType();
    }
    
    public static LongType long_(){
        return new LongType();
    }

}
