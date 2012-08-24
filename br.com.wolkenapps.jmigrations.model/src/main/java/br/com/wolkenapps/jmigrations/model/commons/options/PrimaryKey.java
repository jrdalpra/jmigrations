package br.com.wolkenapps.jmigrations.model.commons.options;

import java.util.*;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.ExtensionMethod;
import br.com.wolkenapps.jmigrations.model.domain.*;
import br.com.wolkenapps.utils.ConfirmsThat;

@RequiredArgsConstructor
@ExtensionMethod({ Arrays.class, ConfirmsThat.class })
public class PrimaryKey implements RestrictedOption {

    @Getter
    private final Set<Column> columns;

    public PrimaryKey(List<Column> columns) {
        this(new LinkedHashSet<>(columns));
    }

    public PrimaryKey(String... columns) {
        this(Column.Utils.createBasedOn(columns));
    }

    @Override
    public String representation() {
        return "primarykey";
    }

    @Override
    public <T> boolean canBeAppliedOn(T target) {
        return target.isInstanceOf(Column.class) ||
               target.isInstanceOf(Table.class);
    }

}
