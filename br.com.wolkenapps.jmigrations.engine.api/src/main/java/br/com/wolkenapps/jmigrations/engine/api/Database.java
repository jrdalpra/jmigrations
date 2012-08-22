package br.com.wolkenapps.jmigrations.engine.api;

import br.com.wolkenapps.jmigrations.api.Migration;
import br.com.wolkenapps.jmigrations.dsl.model.DatabaseObject;

public interface Database {

    void up(Migration... migrations);

    void down(Migration... migrations);

    Boolean contains(DatabaseObject object);

}
