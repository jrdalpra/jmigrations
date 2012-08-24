package br.com.wolkenapps.jmigrations.model.commons.options;

import br.com.wolkenapps.jmigrations.model.domain.Option;


public class IfNotExists implements Option {

    @Override
    public String representation() {
        return IfNotExists.class.getSimpleName().toLowerCase();
    }

}
