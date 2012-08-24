package br.com.wolkenapps.jmigrations.model.domain;

import java.util.*;

import br.com.wolkenapps.jmigrations.model.commands.alter.actions.stereotypes.CanBeRenamed;
import br.com.wolkenapps.jmigrations.model.commons.stereotype.HasOptions;
import br.com.wolkenapps.jmigrations.model.domain.sequences.options.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.ExtensionMethod;

@RequiredArgsConstructor
@ExtensionMethod({ Arrays.class })
public class Sequence implements HasOptions<Sequence>, CanBeRenamed {

    @Getter
    private final String      name;

    private final Set<Option> options;

    public Sequence(String name) {
        this(name, new LinkedHashSet<Option>());
    }

    public Sequence() {
        this(null);
    }

    @Override
    public Sequence withOptions(Option... options) {
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

    public Sequence incrementBy(Number increment) {
        return withOptions(new IncrementBy(increment));
    }

    public Sequence startWith(Number start) {
        return withOptions(new StartWith(start));
    }

    public Sequence maxValue(Number value) {
        return withOptions(new MaxValue(value));
    }

    public Sequence minValue(Number value) {
        return withOptions(new MinValue(value));
    }

}
