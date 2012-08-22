package br.com.wolkenapps.jmigrations.dsl.model.commons.options;


public class IfExists implements DatabaseObjectOption {

    @Override
    public String representation() {
        return IfExists.class.getSimpleName().toLowerCase();
    }

}
