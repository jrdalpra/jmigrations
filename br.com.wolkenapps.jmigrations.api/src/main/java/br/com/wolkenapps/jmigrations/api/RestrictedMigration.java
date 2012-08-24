package br.com.wolkenapps.jmigrations.api;

public interface RestrictedMigration extends Migration {

    boolean canBeAppliedOn(Database target);

}
