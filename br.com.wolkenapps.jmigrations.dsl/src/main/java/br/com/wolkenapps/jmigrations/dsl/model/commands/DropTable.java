package br.com.wolkenapps.jmigrations.dsl.model.commands;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import lombok.Getter;
import br.com.wolkenapps.jmigrations.api.DatabaseCommand;
import br.com.wolkenapps.jmigrations.dsl.model.commands.options.droptable.DropTableOption;
import br.com.wolkenapps.jmigrations.dsl.model.table.Table;

public class DropTable implements DatabaseCommand {

    @Getter
    private final Table          table;

    private Set<DropTableOption> options = new HashSet<>();

    public DropTable(String name) {
        this.table = new Table(name);
    }

    public Set<DropTableOption> getOptions() {
        return Collections.unmodifiableSet(options);
    }

    public DropTable withOptions(DropTableOption... options) {
        this.options.addAll(Arrays.asList(options));
        return this;
    }

}
