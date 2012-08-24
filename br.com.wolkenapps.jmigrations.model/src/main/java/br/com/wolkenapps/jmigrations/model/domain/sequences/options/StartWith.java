package br.com.wolkenapps.jmigrations.model.domain.sequences.options;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.ExtensionMethod;
import br.com.wolkenapps.jmigrations.model.domain.*;
import br.com.wolkenapps.utils.ConfirmsThat;

@RequiredArgsConstructor
@ExtensionMethod({ ConfirmsThat.class })
public class StartWith implements RestrictedOption {

    @Getter
    private final Number start;

    public StartWith() {
        this(1);
    }

    @Override
    public String representation() {
        return StartWith.class.getSimpleName().toLowerCase();
    }

    @Override
    public <T> boolean canBeAppliedOn(T target) {
        return target.isInstanceOf(Sequence.class);
    }

}
