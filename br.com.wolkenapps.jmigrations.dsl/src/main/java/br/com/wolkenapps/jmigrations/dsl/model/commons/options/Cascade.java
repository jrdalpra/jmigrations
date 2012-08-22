package br.com.wolkenapps.jmigrations.dsl.model.commons.options;

public class Cascade implements DatabaseObjectOption {

    @Override
    public String representation() {
        return Cascade.class.getSimpleName().toLowerCase();
    }

}
