package br.com.wolkenapps.jmigrations.model.commons.options;

import br.com.wolkenapps.jmigrations.model.domain.Option;

public class UniqueConstraint implements Option {

    @Override
    public String representation() {
        return "unique";
    }

}
