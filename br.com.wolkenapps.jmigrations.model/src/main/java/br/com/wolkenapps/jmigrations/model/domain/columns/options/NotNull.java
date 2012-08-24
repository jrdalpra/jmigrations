package br.com.wolkenapps.jmigrations.model.domain.columns.options;

import lombok.experimental.ExtensionMethod;
import br.com.wolkenapps.jmigrations.model.domain.*;
import br.com.wolkenapps.utils.ConfirmsThat;

@ExtensionMethod({ ConfirmsThat.class })
public class NotNull implements RestrictedOption {

    @Override
    public String representation() {
        return NotNull.class.getSimpleName().toLowerCase();
    }

    @Override
    public <T> boolean canBeAppliedOn(T target) {
        return target.isInstanceOf(Column.class);
    }

}
