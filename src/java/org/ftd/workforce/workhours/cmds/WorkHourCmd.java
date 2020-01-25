package org.ftd.workforce.workhours.cmds;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.ftd.workforce.workhours.services.SecurityManager;
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
        req.setAttribute("entity", null);
        req.setAttribute("projects", findProjects(req));        
        req.setAttribute("completeness", getCompletenessRange(req));
        req.setAttribute("workhoursday", getWorkHoursDayRange(req));        
        
        String projectId = readParameter(req, "comboProject", null);
        if (projectId != null) {
            req.setAttribute("projectId", projectId);
            req.setAttribute("activities", findActivities(req, Long.parseLong(projectId)));
        } else {
            req.setAttribute("activities", null);
        }
        
        return nextCmd;
    }

    // PRIVATE MEMBERS...    
    private List<IdNameAdapter> findProjects(HttpServletRequest req) {
        List<IdNameAdapter> lst = new ArrayList();
        
        lst.add(new IdNameAdapter(null, null));
        lst.add(new IdNameAdapter(1L, "Catalágo de Produtos"));
        lst.add(new IdNameAdapter(2L, "Propaga"));
        lst.add(new IdNameAdapter(3L, "Franquias"));

        return lst;
    }

    // PRIVATE MEMBERS...    
    private List<IdNameAdapter> findActivities(HttpServletRequest req, Long projectId) {
        List<IdNameAdapter> lst = new ArrayList();

        lst.add(new IdNameAdapter(null, null));
        lst.add(new IdNameAdapter(1L, "Atividade-1"));
        lst.add(new IdNameAdapter(2L, "Atividade-2"));
        lst.add(new IdNameAdapter(3L, "Atividade-3"));
        lst.add(new IdNameAdapter(4L, "Atividade-4"));
        lst.add(new IdNameAdapter(5L, "Atividade-5"));
        lst.add(new IdNameAdapter(6L, "Atividade-6"));

        return lst;
    }

    // PRIVATE MEMBERS...    
    private List<IdNameAdapter> getCompletenessRange(HttpServletRequest req) {
        List<IdNameAdapter> lst = new ArrayList();

        lst.add(new IdNameAdapter(0L, "0%"));
        lst.add(new IdNameAdapter(25L, "25%"));
        lst.add(new IdNameAdapter(50L, "50%"));
        lst.add(new IdNameAdapter(75L, "75%"));
        lst.add(new IdNameAdapter(100L, "100%"));

        return lst;
    }    

    // PRIVATE MEMBERS...    
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
