package br.com.wolkenapps.jmigrations.dsl;

import br.com.wolkenapps.jmigrations.model.domain.columns.types.*;

public class Types {

    private Types() {
    }

    public static StringDataType string() {
        return new StringDataType();
    }

    public static BooleanDataType boolean_() {
        return new BooleanDataType();
    }

    // TODO enum

    public static IntegerDataType integer() {
        return new IntegerDataType();
    }

    public static LongDataType long_() {
        return new LongDataType();
    }

    public static FloatDataType float_() {
        return new FloatDataType();
    }

    public static DoubleDataType double_() {
        return new DoubleDataType();
    }

    public static BigDecimalDataType bigDecimal() {
        return new BigDecimalDataType();
    }

    public static BinaryDataType binary() {
        return new BinaryDataType();
    }

    public static TimeDataType time() {
        return new TimeDataType();
    }

    public static DateDataType date() {
        return new DateDataType();
    }

    public static DateTimeDataType dateTime() {
        return new DateTimeDataType();
    }

}
