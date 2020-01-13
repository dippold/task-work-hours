
package org.ftd.workforce.workhours.enums;

import java.util.LinkedList;

/**
 *
 * @author Fabio Tavares Dippold
 * @version 1.0.0
 * @since 2020-01-11
 *
 */
public enum APP {
    
    PERSISTENCE_UNIT("TasksPU"),
    APP_NAME("Work Hours"), 
    CMD_HOME("HomeCmd"),
    CMD_LOGOUT("LogOutCmd");
    
    public static String[] getNames() {
        java.util.LinkedList<String> list = new LinkedList<>();
        for (APP o : APP.values()) {
            list.add(o.name());
        }

        return list.toArray(new String[list.size()]);
    }
    
    private final String value;
    
    APP(String value) {
        this.value = value;
    }  
    
    public String getValue() {
        return value;
    }    
}
