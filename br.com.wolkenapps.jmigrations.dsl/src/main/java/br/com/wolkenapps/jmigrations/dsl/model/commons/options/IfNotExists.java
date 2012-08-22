package br.com.wolkenapps.jmigrations.dsl.model.commons.options;


public class IfNotExists implements DatabaseObjectOption {

    @Override
    public String representation() {
        return IfNotExists.class.getSimpleName().toLowerCase();
    }

}
