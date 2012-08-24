package br.com.wolkenapps.jmigrations.model.commands.alter.actions;

import java.util.*;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.ExtensionMethod;
import br.com.wolkenapps.jmigrations.model.commands.AlterAction;
import br.com.wolkenapps.jmigrations.model.commons.stereotype.HasOptions;
import br.com.wolkenapps.jmigrations.model.domain.Option;
import br.com.wolkenapps.utils.ConfirmsThat;

@RequiredArgsConstructor
@ExtensionMethod({ Arrays.class, ConfirmsThat.class })
public class Add<Something> implements AlterAction<Add<Something>> {

    @Getter
    private final Something   toBeAdded;

    private final Set<Option> options;

    public Add(Something toBeAdded) {
        this(toBeAdded, new LinkedHashSet<Option>());
    }

    @Override
    public Add<Something> withOptions(Option... options) {
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

    public <T> Boolean isSomethingAnInstanceOf(Class<T> type) {
        return this.toBeAdded.isInstanceOf(type);
    }

}
