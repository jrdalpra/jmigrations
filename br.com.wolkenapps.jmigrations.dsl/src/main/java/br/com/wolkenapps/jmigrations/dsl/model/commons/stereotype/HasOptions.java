package br.com.wolkenapps.jmigrations.dsl.model.commons.stereotype;

import java.util.Set;

import br.com.wolkenapps.jmigrations.dsl.model.commons.options.DatabaseObjectOption;

public interface HasOptions<Self> {

    Self withOptions(DatabaseObjectOption... options);

    Set<DatabaseObjectOption> options();

    <T extends DatabaseObjectOption> Boolean contains(Class<T> option);

    Boolean contains(String optionRepresentation);

    public static class $class {
        public static <Self extends HasOptions<Self>, T extends DatabaseObjectOption> Boolean contains(Self self, Class<T> option) {
            for (DatabaseObjectOption it : self.options()) {
                if (option.isInstance(it)) {
                    return true;
                }
            }
            return false;
        }

        public static <Self extends HasOptions<Self>> Boolean contains(Self self, String optionRepresentation) {
            for (DatabaseObjectOption it : self.options()) {
                if (it.representation().equals(optionRepresentation)) {
                    return true;
                }
            }
            return false;
        }
    }

}
