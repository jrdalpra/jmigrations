package br.com.wolkenapps.jmigrations.model.commands.predicates;

import java.util.Deque;
import java.util.LinkedList;

import br.com.wolkenapps.jmigrations.model.commands.predicates.operators.And;
import lombok.*;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class Where {

    @Getter
    private final Deque<Predicate> predicates;

    public Where() {
        this(new LinkedList<Predicate>());
    }

    public Where(Predicate first) {
        this();
        predicates.addFirst(first);
    }

    public Where and(Predicate and) {
        predicates.addLast(and);
        return this;
    }

    public Where and(String column, Operator operates, Object right) {
        return this.and(new Predicate(new And(), column, operates, right));
    }

    public Where and(Object left, Operator operates, Object right) {
        return this.and(new Predicate(new And(), left, operates, right));
    }
}
