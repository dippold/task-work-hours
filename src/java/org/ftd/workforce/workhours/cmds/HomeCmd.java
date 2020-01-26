package org.ftd.workforce.workhours.cmds;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.builderforce.tasks.persistence.daos.CompanyDAO;
import org.builderforce.tasks.persistence.daos.ProjectDAO;
import org.builderforce.tasks.persistence.daos.TaskDAO;
import org.builderforce.tasks.persistence.daos.UserProjectDAO;
import org.builderforce.tasks.persistence.daos.UserTaskDAO;
import org.builderforce.tasks.persistence.entities.Company;
import org.builderforce.tasks.persistence.entities.Project;
import org.builderforce.tasks.persistence.entities.Task;
import org.builderforce.tasks.persistence.entities.UserProject;
import org.builderforce.tasks.persistence.entities.UserTask;
import org.ftd.workforce.workhours.services.SecurityManager;
import org.builderforce.tasks.persistence.enums.RULES;
import org.ftd.workforce.workhours.adapters.IdNameAdapter;
import org.ftd.workforce.workhours.enums.APP;
import org.ftd.workforce.workhours.services.MenuService;
import org.softwareworkforce.web.mvc.abstracts.AbstractCmd;
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
            req.setAttribute("userProjects", findUserProjects(Long.parseLong(AbstractCmd.getSessionValue(req, "userId"))));
            nextCmd = VIEWS.HOME.getName();
        }

        return nextCmd;
    }

    private List<IdNameAdapter> findUserProjects(Long userId) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(APP.PERSISTENCE_UNIT.getValue());
        ProjectDAO projectDAO = new ProjectDAO(factory);
        CompanyDAO companyDAO = new CompanyDAO(factory);
        UserProjectDAO userProjectDAO = new UserProjectDAO(factory);
        List<UserProject> userProjects = userProjectDAO.findProjects(userId);
        List<IdNameAdapter> lst = new ArrayList<>();

        for (UserProject o : userProjects) {
            Project p = projectDAO.findProject(o.getProjectId());
            Company c = companyDAO.find(p.getCompanyId());
            lst.add(
                    new IdNameAdapter(
                            o.getProjectId(), 
                            p.getName(), 
                            p.getDescription(), 
                            c.getName(),
                            Integer.toString(countProjectUserTasks(userId, p.getId()))
                    ));
        }

        return lst;
    }

    private int countProjectUserTasks(Long userId, Long projectId) {
        int count = 0;
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(APP.PERSISTENCE_UNIT.getValue());
        TaskDAO taskDAO = new TaskDAO(factory);
        UserTaskDAO userTaskDAO = new UserTaskDAO(factory);
        List<Task> projectTasks = taskDAO.findAllByProject(projectId);

        for (Task task : projectTasks) {
            List<UserTask> userTasks = userTaskDAO.find(userId, task.getId());
            count += userTasks.size();
        }

        return count;
    }

}
