package br.com.wolkenapps.jmigrations.model.domain.columns.options;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.ExtensionMethod;
import br.com.wolkenapps.jmigrations.model.domain.*;
import br.com.wolkenapps.utils.ConfirmsThat;

@RequiredArgsConstructor
@ExtensionMethod({ ConfirmsThat.class })
public class DataTypeOption implements RestrictedOption {

    @Getter
    private final DataType type;

    @Override
    public String representation() {
        return "datatype";
    }

    @Override
    public <T> boolean canBeAppliedOn(T target) {
        return target.isInstanceOf(Column.class);
    }

}
