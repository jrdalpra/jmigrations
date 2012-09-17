package br.com.wolkenapps.jmigrations.engine.api.internal;

import java.util.List;

import br.com.wolkenapps.jmigrations.api.Migration;

public interface Finder {

    /**
     * Finds all migrations avaiable
     * 
     * @return all migrations found
     */
    List<Migration> find();

}
