package org.ftd.workforce.workhours.adapters;

import org.builderforce.tasks.persistence.entities.AbstractEntity;

/**
 *
 * @author Fabio.Dippold
 * @version 1.0.0 - 2020-1-16
 *
 */
public class ComboBoxAdapter {
    private final Long id;
    private final String name;
    
    public ComboBoxAdapter(AbstractEntity o) {
        this.id = o.getId();
        this.name = o.getName();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }    
    
}
