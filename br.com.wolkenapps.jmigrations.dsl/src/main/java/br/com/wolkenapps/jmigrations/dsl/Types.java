package br.com.wolkenapps.jmigrations.dsl;

import br.com.wolkenapps.jmigrations.model.domain.columns.types.LongDataType;
import br.com.wolkenapps.jmigrations.model.domain.columns.types.StringDataType;

public class Types {

    private Types() {
    }

    public static StringDataType string() {
        return new StringDataType();
    }
    
    public static LongDataType long_(){
        return new LongDataType();
    }

}
