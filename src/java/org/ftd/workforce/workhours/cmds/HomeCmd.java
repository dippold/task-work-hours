package org.ftd.workforce.workhours.cmds;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.ftd.workforce.workhours.services.MenuService;
import org.softwareworkforce.web.mvc.enums.VIEWS;
import org.softwareworkforce.web.mvc.interfaces.ICmd;

/**
 *
 * @author Fabio.Dippold
 * @version 1.0.0
 * @since 2020-1-11
 *
 */
public class HomeCmd implements ICmd {

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        MenuService.getInstance().buildMenuModel(req);
        
        String nextCmd = VIEWS.HOME.getName();
        
        
        return nextCmd;
    }
    
}
