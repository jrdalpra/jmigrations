package br.com.wolkenapps.jmigrations.api;

import java.sql.Driver;

public interface Database {

    void up(Migration... migrations);

    void down(Migration... migrations);

    Boolean contains(Object object);

    String url();

    Driver driver();

}