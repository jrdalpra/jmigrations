package br.com.wolkenapps.jmigrations.model.domain;

import java.util.*;

import lombok.*;
import lombok.experimental.ExtensionMethod;
import br.com.wolkenapps.jmigrations.model.commons.stereotype.HasOptions;
import br.com.wolkenapps.jmigrations.model.domain.indexes.options.Ascending;
import br.com.wolkenapps.jmigrations.model.domain.indexes.options.Descending;
import br.com.wolkenapps.utils.ConfirmsThat;

@RequiredArgsConstructor
@ExtensionMethod({ Arrays.class })
@EqualsAndHashCode(of = { "name" })
public class IndexColumn implements HasOptions<IndexColumn> {

    @ExtensionMethod({ ConfirmsThat.class })
    public static final class Utils {
        public static List<IndexColumn> createBasedOn(String... names) {
            List<IndexColumn> all = new ArrayList<>();
            for (String name : names) {
                if (name.notIsNull()) {
                    all.add(new IndexColumn(name));
                }
            }
            return all;
        }
    }

    @Getter
    private final String name;

    private Set<Option>  options = new LinkedHashSet<>();

    public IndexColumn() {
        this(null);
    }

    @Override
    public IndexColumn withOptions(Option... options) {
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

    public IndexColumn ascending() {
        return withOptions(new Ascending());
    }

    public IndexColumn asc() {
        return ascending();
    }

    public IndexColumn descending() {
        return withOptions(new Descending());
    }

    public IndexColumn desc() {
        return descending();
    }

}
