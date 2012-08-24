package br.com.wolkenapps.jmigrations.model.commands;

import java.util.*;

import lombok.Getter;
import lombok.experimental.ExtensionMethod;
import br.com.wolkenapps.jmigrations.api.DatabaseCommand;
import br.com.wolkenapps.jmigrations.model.commands.alter.AlterAction;
import br.com.wolkenapps.jmigrations.model.commons.options.*;
import br.com.wolkenapps.jmigrations.model.commons.stereotype.HasOptions;
import br.com.wolkenapps.jmigrations.model.domain.Option;

@ExtensionMethod({ Arrays.class })
public class Drop<Something> implements DatabaseCommand, HasOptions<Drop<Something>>, AlterAction<Drop<Something>> {

    @Getter
    private Something   unnecessary;

    private Set<Option> options = new HashSet<>();

    public Drop(Something unnecessary) {
        this.unnecessary = unnecessary;
    }

    public Drop() {
        this(null);
    }

    @Override
    public Drop<Something> withOptions(Option... options) {
        this.options.addAll(options.asList());
        return this;
    }

    @Override
    public Set<Option> options() {
        return Collections.unmodifiableSet(this.options);
    }

    @Override
    public <T extends Option> Boolean contains(Class<T> option) {
        return HasOptions.Trait.contains(this, option);
    }

    @Override
    public Boolean contains(String optionRepresentation) {
        return HasOptions.Trait.contains(this, optionRepresentation);
    }

    public Drop<Something> ifExists() {
        return withOptions(new IfExists());
    }

    public Drop<Something> cascade() {
        return withOptions(new Cascade());
    }

    public Drop<Something> restrict() {
        return withOptions(new Restrict());
    }

}
