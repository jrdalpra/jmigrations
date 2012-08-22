package br.com.wolkenapps.jmigrations.dsl.model.commons.options;


public class NotNull implements DatabaseObjectOption {

    @Override
    public String representation() {
        return NotNull.class.getSimpleName().toLowerCase();
    }

}
