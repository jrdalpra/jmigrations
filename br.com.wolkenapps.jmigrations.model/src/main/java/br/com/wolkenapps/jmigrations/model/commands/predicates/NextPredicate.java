package br.com.wolkenapps.jmigrations.model.commands.predicates;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class NextPredicate {

    @Getter
    private final Predicate           previous;

    @Getter
    private final ConjunctionOperator operates;

    @Getter
    private final Predicate           current;

}
