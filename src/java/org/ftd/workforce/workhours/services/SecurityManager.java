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
    
    public boolean validate(HttpServletRequest req, RULES[] rules) {
        boolean validate = false;
        int userRuleId = RULES.PROJECT_MANAGER.getId();
        for (RULES rule : rules) {
            if (rule.getId() == userRuleId) {
                validate = true;
                break;
            }
        }
        
        return validate;
    }
    
}
