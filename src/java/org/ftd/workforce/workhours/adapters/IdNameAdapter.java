package org.ftd.workforce.workhours.adapters;

/**
 *
 * @author Fabio.Dippold
 * @version 1.0.0
 * @since 2020-1-15
 *
 */
public class IdNameAdapter {
    private final Long id;
    private final String name;
    private String description;
    private String info1;
    private String info2;

    public IdNameAdapter(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public IdNameAdapter(Long id, String name, String description) {
        this(id, name);
        this.description = description;
    }    

    public IdNameAdapter(Long id, String name, String description, String info1) {
        this(id, name, description);
        this.info1 = info1;
    }     
    
    public IdNameAdapter(Long id, String name, String description, String info1, String info2) {
        this(id, name, description, info1);
        this.info2 = info2;
    }     
    
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }    
    
    public String getDescription() {
        return description;
    }

    public String getInfo1() {
        return info1;
    }

    public String getInfo2() {
        return info2;
    }
    
}
