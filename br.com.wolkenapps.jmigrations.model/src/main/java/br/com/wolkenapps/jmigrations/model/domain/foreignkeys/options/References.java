package br.com.wolkenapps.jmigrations.model.domain.foreignkeys.options;

import java.util.Arrays;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.ExtensionMethod;
import br.com.wolkenapps.jmigrations.model.domain.Option;
import br.com.wolkenapps.jmigrations.model.domain.Table;
import br.com.wolkenapps.utils.ConfirmsThat;

@RequiredArgsConstructor
@ExtensionMethod({ Arrays.class, ConfirmsThat.class })
public class References implements Option {

    @Getter
    private final Table otherSide;

    @Override
    public String representation() {
        return References.class.getSimpleName().toLowerCase();
    }

}
