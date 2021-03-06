package br.com.wolkenapps.jmigrations.model.domain.indexes.options;

import lombok.experimental.ExtensionMethod;
import br.com.wolkenapps.jmigrations.model.domain.IndexColumn;
import br.com.wolkenapps.jmigrations.model.domain.RestrictedOption;
import br.com.wolkenapps.utils.ConfirmsThat;

@ExtensionMethod({ ConfirmsThat.class })
public class Ascending implements RestrictedOption {

    @Override
    public String representation() {
        return "asc";
    }

    @Override
    public <T> boolean canBeAppliedOn(T target) {
        return target.isInstanceOf(IndexColumn.class);
    }

}
