package br.com.wolkenapps.jmigrations.model.commands;

import java.util.*;

import lombok.Getter;
import lombok.experimental.ExtensionMethod;
import br.com.wolkenapps.jmigrations.api.DatabaseCommand;
import br.com.wolkenapps.jmigrations.model.commons.options.IfNotExists;
import br.com.wolkenapps.jmigrations.model.commons.stereotype.HasOptions;
import br.com.wolkenapps.jmigrations.model.domain.Option;

@ExtensionMethod({ Arrays.class })
public class Create<Something> implements DatabaseCommand, HasOptions<Create<Something>> {

    @Getter
    private Something   something;

    private Set<Option> options = new LinkedHashSet<>();

    public Create(Something something) {
        this.something = something;
    }

    public Create() {
        this(null);
    }

    @Override
    public Create<Something> withOptions(Option... options) {
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

    public Create<Something> ifNotExists() {
        return withOptions(new IfNotExists());
    }

    public Something define() {
        return this.something;
    }

}
