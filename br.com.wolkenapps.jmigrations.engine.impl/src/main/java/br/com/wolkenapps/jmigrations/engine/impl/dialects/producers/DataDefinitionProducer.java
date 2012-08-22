package br.com.wolkenapps.jmigrations.engine.impl.dialects.producers;

public interface DataDefinitionProducer<T extends DataDefinitionProducer<T, WhatToProduces>, WhatToProduces> {

    Boolean accepts(WhatToProduces something);

    String producesDDLFor(WhatToProduces something);

}
