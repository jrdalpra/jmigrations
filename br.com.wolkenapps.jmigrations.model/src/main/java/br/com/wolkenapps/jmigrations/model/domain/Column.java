package br.com.wolkenapps.jmigrations.model.domain;

import java.util.*;

import lombok.*;
import lombok.experimental.ExtensionMethod;
import br.com.wolkenapps.jmigrations.model.commands.alter.actions.stereotypes.CanBeRenamed;
import br.com.wolkenapps.jmigrations.model.commons.options.PrimaryKey;
import br.com.wolkenapps.jmigrations.model.commons.stereotype.HasOptions;
import br.com.wolkenapps.jmigrations.model.domain.columns.options.*;
import br.com.wolkenapps.jmigrations.model.domain.foreignkeys.options.References;
import br.com.wolkenapps.utils.ConfirmsThat;

@RequiredArgsConstructor
@ExtensionMethod({ Arrays.class, ConfirmsThat.class })
@EqualsAndHashCode(of = { "name" })
public class Column implements HasOptions<Column>, CanBeRenamed {

    public static final class Utils {
        public static List<Column> createBasedOn(String... names) {
            return createArrayBasedOn(names).asList();
        }

        public static Column[] createArrayBasedOn(String... names) {
            if (names.notIsEmpty()) {
                Column[] columns = new Column[names.length];
                int size = names.length;
                for (int current = 0; current < size; current++) {
                    columns[current] = new Column(names[current]);
                }
                return columns;
            }
            return new Column[] {};
        }
    }

    @Getter
    private final String name;

    private Set<Option>  options = new HashSet<>();

    public Column withOptions(Option... options) {
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

    public Column type(DataType type) {
        return withOptions(new DataTypeOption(type));
    }

    public Column notNull() {
        return withOptions(new NotNull());
    }

    public Column length(Number length) {
        return withOptions(new Length(length));
    }

    public Column asPrimaryKey() {
        return withOptions(new PrimaryKey(Arrays.asList(this)));
    }

    public Column defaultValue(Object value) {
        return withOptions(new DefaultValue(value));
    }

    public Column foreignKey(String name, References otherSide) {
        return withOptions(new ForeignKey(name).column(this).references(otherSide));
    }

    public Column foreignKey(String name, Table otherSide) {
        return withOptions(new ForeignKey(name).column(this).references(otherSide));
    }
}
