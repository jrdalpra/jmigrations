package br.com.wolkenapps.jmigrations.model.commands;

import java.util.*;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.ExtensionMethod;
import br.com.wolkenapps.jmigrations.api.DatabaseCommand;
import br.com.wolkenapps.jmigrations.model.commands.alter.AlterAction;
import br.com.wolkenapps.jmigrations.model.commons.stereotype.HasOptions;
import br.com.wolkenapps.jmigrations.model.domain.Option;

@RequiredArgsConstructor
@ExtensionMethod({ Arrays.class })
public class Alter<Something> implements DatabaseCommand, HasOptions<Alter<Something>> {

    @Getter
    private final Something      something;

    @Getter
    private final AlterAction<?> action;

    private final Set<Option>    options;

    public Alter(Something something, AlterAction<?> action) {
        this(something, action, new LinkedHashSet<Option>());
    }

    public Alter<Something> withOptions(Option... options) {
        this.options.addAll(options.asList());
        return this;
    }

    @Override
    public Set<Option> options() {
        return HasOptions.Trait.options(this.options);
    }

    @Override
    public <O extends Option> Boolean contains(Class<O> option) {
        return HasOptions.Trait.contains(this, option);
    }

    @Override
    public Boolean contains(String optionRepresentation) {
        return HasOptions.Trait.contains(this, optionRepresentation);
    }

}
