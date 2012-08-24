package br.com.wolkenapps.jmigrations.model.domain.columns.options;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.ExtensionMethod;
import br.com.wolkenapps.jmigrations.model.domain.Column;
import br.com.wolkenapps.jmigrations.model.domain.RestrictedOption;
import br.com.wolkenapps.utils.ConfirmsThat;

@RequiredArgsConstructor
@ExtensionMethod({ ConfirmsThat.class })
public class DefaultValue implements RestrictedOption {

    @Getter
    private final Object value;

    @Override
    public String representation() {
        return DefaultValue.class.getSimpleName().toLowerCase();
    }

    @Override
    public <T> boolean canBeAppliedOn(T target) {
        return target.isInstanceOf(Column.class);
    }

}
