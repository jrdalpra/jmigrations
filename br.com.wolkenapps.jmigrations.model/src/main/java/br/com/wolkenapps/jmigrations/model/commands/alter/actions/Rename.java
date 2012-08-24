package br.com.wolkenapps.jmigrations.model.commands.alter.actions;

import java.util.*;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.ExtensionMethod;
import br.com.wolkenapps.jmigrations.model.commands.AlterAction;
import br.com.wolkenapps.jmigrations.model.commands.alter.actions.stereotypes.CanBeRenamed;
import br.com.wolkenapps.jmigrations.model.commons.stereotype.HasOptions;
import br.com.wolkenapps.jmigrations.model.domain.Option;
import br.com.wolkenapps.utils.ConfirmsThat;

@RequiredArgsConstructor
@ExtensionMethod({ Arrays.class, ConfirmsThat.class })
public class Rename<Something extends CanBeRenamed> implements AlterAction<Rename<Something>> {

    @RequiredArgsConstructor
    public static final class Self implements CanBeRenamed {

        @Getter
        private final Object self;

        @Getter
        private final String name;

        public Self(String name) {
            this(null, name);
        }

    }

    @Getter
    private final Something   from;

    @Getter
    private final Something   to;

    private final Set<Option> options;

    public Rename(Something from, Something to) {
        this(from, to, new LinkedHashSet<Option>());
    }

    @Override
    public Rename<Something> withOptions(Option... options) {
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

    public Boolean isASelfRenaming() {
        return from.isInstanceOf(Self.class);
    }

}
