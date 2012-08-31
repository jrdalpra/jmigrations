package br.com.wolkenapps.jmigrations.model.commands;

import java.util.*;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.ExtensionMethod;
import br.com.wolkenapps.jmigrations.api.DatabaseCommand;
import br.com.wolkenapps.jmigrations.model.commands.predicates.Where;
import br.com.wolkenapps.jmigrations.model.domain.Table;

@RequiredArgsConstructor
@ExtensionMethod({ Arrays.class })
public class DeleteFrom implements DatabaseCommand {

    @Getter
    private final Table target;

    @Getter
    private final Where clause;

    public DeleteFrom(String target, Where clause) {
        this(new Table(target), clause);
    }

}
