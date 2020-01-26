package org.ftd.workforce.workhours.cmds;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.builderforce.tasks.persistence.daos.ProjectDAO;
import org.builderforce.tasks.persistence.daos.TaskDAO;
import org.builderforce.tasks.persistence.daos.UserTaskDAO;
import org.builderforce.tasks.persistence.entities.Project;
import org.builderforce.tasks.persistence.entities.Task;
import org.builderforce.tasks.persistence.entities.UserTask;
import org.builderforce.tasks.persistence.enums.RULES;
import org.ftd.workforce.workhours.adapters.IdNameAdapter;
import org.ftd.workforce.workhours.enums.APP;
import org.ftd.workforce.workhours.services.MenuService;
import org.softwareworkforce.web.mvc.abstracts.AbstractCmd;
import org.softwareworkforce.web.mvc.enums.CRUD;
import org.softwareworkforce.web.mvc.enums.MODEL;
import org.softwareworkforce.web.mvc.enums.MVC;
import org.softwareworkforce.web.mvc.interfaces.ICmd;
import org.ftd.workforce.workhours.services.SecurityManager;

/**
 *
 * @author Fabio.Dippold
 * @version 1.0.0
 * @since 2020-1-15
 *
 */
public class WorkHourCmd extends AbstractCmd implements ICmd {

    public static final RULES[] PERMISSIONS = {
        RULES.PROJECT_TEAM,
        RULES.PROJECT_MANAGER,
        RULES.TASK_ADMIN
    };

    @Override
    public boolean securityValidated(HttpServletRequest req) {
        return SecurityManager.getInstance().validate(req, PERMISSIONS);
    }

    public String addModel(HttpServletRequest req, HttpServletResponse res) {
        // MENU...
        MenuService.getInstance().buildMenuModel(req);
        // VIEW...
        String nextCmd = "WEB-INF/views/RegisterWork.jsp";
        // MVC...
        req.setAttribute("viewName", "Registrar trabalho");
        //req.setAttribute("url", MVC.URL.getName());
        req.setAttribute("url", "show");
        req.setAttribute("urlSrv", MVC.URL_SRV.getName());
        req.setAttribute(MVC.CMD.getName(), this.getClass().getSimpleName());
        req.setAttribute(MVC.ACTION.getName(), CRUD.ADD.getName());
        req.setAttribute(MVC.ID.getName(), "0");
        req.setAttribute(MVC.PID.getName(), "0");
        req.setAttribute(MVC.PPID.getName(), "0");
        req.setAttribute(MVC.MSG.getName(), null);
        // FORM...
        req.setAttribute("btnSubmitLabel", "Registrar");
        req.setAttribute("btnCancelLabel", "Cancelar");
        req.setAttribute("urlToCancel", buildUrl(APP.CMD_HOME.getValue(), MODEL.LST.getName()));
        // DATASOURCES...
        String id = readParameter(req, "id", null);
        if (id == null) { // addNew Mode...
            req.setAttribute("entity", null);
            String projectId = readParameter(req, "projectid", null);
            if (projectId != null) {
                req.setAttribute("project", findProject(Long.parseLong(projectId)));
                Long userId = Long.parseLong(getSessionValue(req, "userId"));
                req.setAttribute("activities", findTaks(userId, Long.parseLong(projectId)));
            }
        } else { // updateMode...

        }

        req.setAttribute("completeness", getCompletenessRange(req));
        req.setAttribute("workhoursday", getWorkHoursDayRange(req));

        return nextCmd;
    }

    // PRIVATE MEMBERS...
    private Project findProject(Long id) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(APP.PERSISTENCE_UNIT.getValue());
        ProjectDAO projectDAO = new ProjectDAO(factory);

        return projectDAO.findProject(id);
    }

    private List<IdNameAdapter> findTaks(Long userId, Long projectId) {
        List<IdNameAdapter> lst = new ArrayList();
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(APP.PERSISTENCE_UNIT.getValue());
        TaskDAO taskDAO = new TaskDAO(factory);
        UserTaskDAO userTaskDAO = new UserTaskDAO(factory);
        List<Task> projectTasks = taskDAO.findAllByProject(projectId);

        lst.add(new IdNameAdapter(null, null));
        
//        for (Task task:projectTasks) {
//            List<UserTask> userTasks = userTaskDAO.find(userId, task.getId());
//            if (!userTasks.isEmpty()) {
//                lst.add(new IdNameAdapter(task.getId(), task.getName()));
//            }
//        }

        projectTasks.forEach((task) -> {
            List<UserTask> userTasks = userTaskDAO.find(userId, task.getId());
            if (!userTasks.isEmpty()) {
                lst.add(new IdNameAdapter(task.getId(), task.getName()));
            }
        });

        return lst;
    }

    private List<IdNameAdapter> getCompletenessRange(HttpServletRequest req) {
        List<IdNameAdapter> lst = new ArrayList();

        lst.add(new IdNameAdapter(0L, "0%"));
        lst.add(new IdNameAdapter(25L, "25%"));
        lst.add(new IdNameAdapter(50L, "50%"));
        lst.add(new IdNameAdapter(75L, "75%"));
        lst.add(new IdNameAdapter(100L, "100%"));

        return lst;
    }

    private List<IdNameAdapter> getWorkHoursDayRange(HttpServletRequest req) {
        List<IdNameAdapter> lst = new ArrayList();

        lst.add(new IdNameAdapter(1L, "1"));
        lst.add(new IdNameAdapter(2L, "2"));
        lst.add(new IdNameAdapter(3L, "3"));
        lst.add(new IdNameAdapter(4L, "4"));
        lst.add(new IdNameAdapter(5L, "5"));
        lst.add(new IdNameAdapter(6L, "6"));
        lst.add(new IdNameAdapter(7L, "7"));
        lst.add(new IdNameAdapter(8L, "8"));
        lst.add(new IdNameAdapter(9L, "9"));
        lst.add(new IdNameAdapter(10L, "10"));
        lst.add(new IdNameAdapter(11L, "11"));
        lst.add(new IdNameAdapter(12L, "12"));

        return lst;
    }

}
