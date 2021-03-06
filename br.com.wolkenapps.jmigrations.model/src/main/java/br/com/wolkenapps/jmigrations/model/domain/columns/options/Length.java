package br.com.wolkenapps.jmigrations.model.domain.columns.options;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.ExtensionMethod;
import br.com.wolkenapps.jmigrations.model.domain.*;
import br.com.wolkenapps.utils.ConfirmsThat;

@RequiredArgsConstructor
@ExtensionMethod({ ConfirmsThat.class })
public class Length implements RestrictedOption {

    @Getter
    private final Number length;

    @Override
    public String representation() {
        return Length.class.getSimpleName().toLowerCase();
    }

    @Override
    public <T> boolean canBeAppliedOn(T target) {
        return target.isInstanceOf(Column.class);
    }

}
