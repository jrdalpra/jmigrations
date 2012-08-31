package br.com.wolkenapps.jmigrations.model.commands.predicates;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import br.com.wolkenapps.jmigrations.model.commands.predicates.operators.And;
import br.com.wolkenapps.jmigrations.model.domain.Column;

@RequiredArgsConstructor
public class Predicate {

    @Getter
    private final ConjunctionOperator conjunction;

    @Getter
    private final Object              left;

    @Getter
    private final Operator            operates;

    @Getter
    private final Object              right;

    public Predicate(String column, Operator operates, Object right) {
        this(null, column, operates, right);
    }

    public Predicate(Object left, Operator operates, Object right) {
        this(null, left, operates, right);
    }

    public Predicate(ConjunctionOperator conjunction, String column, Operator operates, Object right) {
        this(conjunction, new Column(column), operates, right);
    }

    /**
     * just append another {@link Predicate}
     * 
     * @param and to be appended
     * @return new {@link Predicate} while this {@link And} other
     */
    public Predicate and(Predicate other) {
        return new Predicate(this, new And(), other);
    }

}
