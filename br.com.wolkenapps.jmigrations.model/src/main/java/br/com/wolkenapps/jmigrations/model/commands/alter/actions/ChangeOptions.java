package br.com.wolkenapps.jmigrations.model.commands.alter.actions;

import java.util.*;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.ExtensionMethod;
import br.com.wolkenapps.jmigrations.model.commands.AlterAction;
import br.com.wolkenapps.jmigrations.model.commons.stereotype.HasOptions;
import br.com.wolkenapps.jmigrations.model.domain.Option;

@RequiredArgsConstructor
@ExtensionMethod({ Arrays.class })
public class ChangeOptions<Something> implements AlterAction<ChangeOptions<Something>> {

    @Getter
    private final Something   toBeChanged;

    private final Set<Option> options;

    public ChangeOptions(Something toBeChanged) {
        this(toBeChanged, new LinkedHashSet<Option>());
    }

    @Override
    public ChangeOptions<Something> withOptions(Option... options) {
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
