package br.com.wolkenapps.jmigrations.dsl;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import br.com.wolkenapps.jmigrations.model.commands.predicates.*;
import br.com.wolkenapps.jmigrations.model.commands.predicates.operators.*;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Restrictions {

    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public static class Predicates {

    }

    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public static class Operators {
        public static And and() {
            return new And();
        }

        public static Or or() {
            return new Or();
        }

        public static Equals equalsTo() {
            return new Equals();
        }

    }

    public static Where where(Predicate first) {
        return new Where().and(first);
    }

    public static Where where(String left, Operator operates, Object value) {
        return new Where(new Predicate(null, left, operates, value));
    }

    public static Where where(Object left, Operator operates, Object value) {
        return new Where(new Predicate(null, left, operates, value));
    }

}
