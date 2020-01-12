package org.ftd.workforce.workhours.cmds;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.softwareworkforce.web.mvc.enums.MVC;
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

        String nextCmd = VIEWS.HOME.getName();

        req.setAttribute(MVC.MSG.getName(), "Seja bem-vindo!");
        
        return nextCmd;
    }
    
}
