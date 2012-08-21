package br.com.wolkenapps.jmigrations.api;

public interface Migration {

    DatabaseCommand[] up();

    DatabaseCommand[] down();

}
