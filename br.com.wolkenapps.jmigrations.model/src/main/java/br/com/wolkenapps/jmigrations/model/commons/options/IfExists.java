package br.com.wolkenapps.jmigrations.model.commons.options;

import br.com.wolkenapps.jmigrations.model.domain.Option;

public class IfExists implements Option {

    @Override
    public String representation() {
        return IfExists.class.getSimpleName().toLowerCase();
    }

}
