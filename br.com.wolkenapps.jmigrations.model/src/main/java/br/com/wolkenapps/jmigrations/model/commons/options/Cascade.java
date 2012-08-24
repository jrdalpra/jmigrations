package br.com.wolkenapps.jmigrations.model.commons.options;

import br.com.wolkenapps.jmigrations.model.domain.Option;

public class Cascade implements Option {

    @Override
    public String representation() {
        return Cascade.class.getSimpleName().toLowerCase();
    }

}
