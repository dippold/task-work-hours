package org.ftd.workforce.workhours.services;

import javax.servlet.http.HttpServletRequest;
import org.builderforce.tasks.persistence.enums.RULES;

/**
 *
 * @author Fabio Tavares Dippold
 * @version 1.0.0
 * @since 2020-01-13
 *
 */
public class SecurityManager {

    private static final SecurityManager INSTANCE;

    static {
        INSTANCE = new SecurityManager();
    }

    public static SecurityManager getInstance() {
        return INSTANCE;
    } 
    
    private SecurityManager() {        
    }
    
    public void validate(HttpServletRequest req, RULES[] rule) {
        
    }
    
}
