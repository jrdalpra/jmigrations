package br.com.wolkenapps.jmigrations.dsl.model.commands;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import lombok.Getter;
import br.com.wolkenapps.jmigrations.api.DatabaseCommand;
import br.com.wolkenapps.jmigrations.dsl.model.commons.options.DatabaseObjectOption;
import br.com.wolkenapps.jmigrations.dsl.model.commons.stereotype.CanUseCascade;
import br.com.wolkenapps.jmigrations.dsl.model.commons.stereotype.CanUseIfExists;
import br.com.wolkenapps.jmigrations.dsl.model.commons.stereotype.HasOptions;
import br.com.wolkenapps.jmigrations.dsl.model.table.Table;

public class DropTable implements DatabaseCommand, HasOptions<DropTable>, CanUseIfExists, CanUseCascade {

    @Getter
    private final Table               table;

    private Set<DatabaseObjectOption> options = new HashSet<>();

    public DropTable(String name) {
        this.table = new Table(name);
    }

    @Override
    public DropTable withOptions(DatabaseObjectOption... options) {
        this.options.addAll(Arrays.asList(options));
        return this;
    }

    @Override
    public Set<DatabaseObjectOption> options() {
        return Collections.unmodifiableSet(this.options);
    }

    @Override
    public <T extends DatabaseObjectOption> Boolean contains(Class<T> option) {
        return HasOptions.$class.contains(this, option);
    }

    @Override
    public Boolean contains(String optionRepresentation) {
        return HasOptions.$class.contains(this, optionRepresentation);
    }
}
