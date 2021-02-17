package edu.eci.arsw.blueprints.filters;

import edu.eci.arsw.blueprints.model.Blueprint;

import java.util.Set;


public interface Filter {

    /**
     * @param blueprint blueprint
     * @return filtered blueprint
     */
    public Blueprint filterBlueprint(Blueprint blueprint);

    /**
     * @param blueprints set off blueprint
     * @return filtered a set off blueprint
     */
    public Set<Blueprint> multiFilter(Set<Blueprint> blueprints);
}
