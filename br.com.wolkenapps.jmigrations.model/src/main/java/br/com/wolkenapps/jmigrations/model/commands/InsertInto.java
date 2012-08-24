package br.com.wolkenapps.jmigrations.model.commands;

import java.util.*;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.ExtensionMethod;
import br.com.wolkenapps.jmigrations.api.DatabaseCommand;
import br.com.wolkenapps.jmigrations.model.domain.Table;

@RequiredArgsConstructor
@ExtensionMethod({ Arrays.class })
public class InsertInto implements DatabaseCommand {

    @Getter
    private final Table        target;

    private final List<Object> values;

    public InsertInto(String target) {
        this(new Table(target));
    }

    public InsertInto(Table target) {
        this(target, new ArrayList<Object>());
    }

    public List<Object> getValues() {
        return Collections.unmodifiableList(values);
    }

    public InsertInto columns(String... columns) {
        this.target.columns(columns);
        return this;
    }

    public InsertInto values(Object... values) {
        this.values.addAll(values.asList());
        return this;
    }

}
