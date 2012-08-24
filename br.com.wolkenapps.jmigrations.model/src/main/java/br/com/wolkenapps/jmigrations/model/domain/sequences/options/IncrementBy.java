package br.com.wolkenapps.jmigrations.model.domain.sequences.options;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.ExtensionMethod;
import br.com.wolkenapps.jmigrations.model.domain.RestrictedOption;
import br.com.wolkenapps.jmigrations.model.domain.Sequence;
import br.com.wolkenapps.utils.ConfirmsThat;

@RequiredArgsConstructor
@ExtensionMethod({ ConfirmsThat.class })
public class IncrementBy implements RestrictedOption {

    @Getter
    private final Number increment;

    public IncrementBy() {
        this(1);
    }

    @Override
    public String representation() {
        return IncrementBy.class.getSimpleName().toLowerCase();
    }

    @Override
    public <T> boolean canBeAppliedOn(T target) {
        return target.isInstanceOf(Sequence.class);
    }

}
