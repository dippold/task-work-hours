package org.ftd.workforce.workhours.cmds;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.softwareworkforce.web.mvc.enums.VIEWS;
import org.softwareworkforce.web.mvc.interfaces.ICmd;

/**
 *
 * @author Fabio.Dippold
 * @version 1.0.0
 * @since 2020-1-15
 *
 */
public class SecurityLogOutCmd implements ICmd {

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String nextCmd = VIEWS.LOGIN.getName();

        HttpSession session = req.getSession(false);
        if (session != null) {
            session.removeAttribute("userId");
            session.removeAttribute("userName");
            session.removeAttribute("userRuleId");
            session.invalidate();
        }

        return nextCmd;
    }

    @Override
    public boolean securityValidated(HttpServletRequest req) {
        return true;
    }

}
