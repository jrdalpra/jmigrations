package br.com.wolkenapps.jmigrations.model.commons.stereotype;

import java.util.Collections;
import java.util.Set;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import br.com.wolkenapps.jmigrations.model.domain.Option;

public interface HasOptions<Self> {

    Self withOptions(Option... options);

    Set<Option> options();

    <O extends Option> Boolean contains(Class<O> option);

    Boolean contains(String optionRepresentation);

    /**
     * inspired on java-scala traits interops (waiting for java 8 :) )
     * 
     * @author jose.junior
     * 
     */
    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public static final class Trait {
        public static <Self extends HasOptions<Self>, T extends Option> Boolean contains(Self self, Class<T> option) {
            Set<Option> options = self.options();
            for (Option it : options) {
                if (option.isInstance(it)) {
                    return true;
                }
            }
            return false;
        }

        public static <Self extends HasOptions<Self>> Boolean contains(Self self, String optionRepresentation) {
            Set<Option> options = self.options();
            for (Option it : options) {
                if (it.representation().equals(optionRepresentation)) {
                    return true;
                }
            }
            return false;
        }

        public static Set<Option> options(Set<Option> options) {
            return Collections.unmodifiableSet(options);
        }

    }

}
