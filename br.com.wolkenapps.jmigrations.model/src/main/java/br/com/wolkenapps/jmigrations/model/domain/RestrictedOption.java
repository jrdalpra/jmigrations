package br.com.wolkenapps.jmigrations.model.domain;

public interface RestrictedOption extends Option {

    <T> boolean canBeAppliedOn(T target);

}
