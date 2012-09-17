package br.com.wolkenapps.jmigrations.engine.api.internal;

import java.util.List;
import java.util.Set;

import br.com.wolkenapps.jmigrations.api.Migration;

public interface Organizer {

    /**
     * Organizes all migrations passed by parameter. </br>
     * 
     * We understand that "organize" means remove duplicate migrations and organizes them on a logical sequence
     * 
     * @param toBeOrganized migrations to be organized
     * @return organized migration's set
     */
    Set<Migration> organize(List<Migration> toBeOrganized);

}
