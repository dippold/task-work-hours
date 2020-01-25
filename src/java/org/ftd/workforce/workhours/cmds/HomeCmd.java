package org.ftd.workforce.workhours.cmds;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.ftd.workforce.workhours.services.SecurityManager;
import org.builderforce.tasks.persistence.enums.RULES;
import org.ftd.workforce.workhours.enums.APP;
import org.ftd.workforce.workhours.services.MenuService;
import org.softwareworkforce.web.mvc.enums.MSGS;
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

    public static final RULES[] PERMISSIONS = {
        RULES.PROJECT_TEAM,
        RULES.PROJECT_MANAGER,
        RULES.TASK_ADMIN,
        RULES.PROJECT_STAKEHOLDER
    };

    @Override
    public boolean securityValidated(HttpServletRequest req) {
        return SecurityManager.getInstance().validate(req, PERMISSIONS);
    }

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        String nextCmd;
        if (!securityValidated(req)) {
            req.setAttribute(MVC.MSG.getName(), MSGS.INVALID_RULE.getName() + this.getClass().getSimpleName());
            nextCmd = APP.URL_SECURITY_LOGOUT.getValue();
        } else {
            MenuService.getInstance().buildMenuModel(req);
            nextCmd = VIEWS.HOME.getName();
        }

        return nextCmd;
    }

}
