package org.ftd.workforce.workhours.services;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.ftd.workforce.workhours.enums.APP;
import org.softwareworkforce.web.mvc.enums.MVC;

/**
 *
 * @author Fabio Tavares Dippold
 * @version 1.0.0
 * @since 2020-01-13
 *
 */
public class MenuService {
    
    private static final MenuService INSTANCE;

    static {
        INSTANCE = new MenuService();
    }

    public static MenuService getInstance() {
        return INSTANCE;
    } 
    
    public void buildMenuModel(HttpServletRequest req) {
        req.setAttribute("appName", APP.APP_NAME.getValue());
        req.setAttribute("userName", getUserShortName(req));
        req.setAttribute("urlToLogout", MVC.URL.getName() + "?" + MVC.CMD.getName() + "=" + APP.CMD_LOGOUT.getValue());
        req.setAttribute("urlToHome", MVC.URL.getName() + "?" + MVC.CMD.getName() + "=" + APP.CMD_HOME.getValue());        
    }
    
    private String getUserShortName(HttpServletRequest req) {
        HttpSession s = req.getSession(false);
        
        return getFirstName((String) s.getAttribute("userName"));
    }
    
    /* UTILITIES MEMBERS... */
    private String getFirstName(String name) {
        String[] splited = name.split(" ");

        return splited[0];
    }
    private String getLastName(String name) {
        String[] splited = name.split(" ");

        return splited[splited.length - 1];
    }    
    
}
