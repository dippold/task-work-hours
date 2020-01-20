package org.ftd.workforce.workhours.cmds;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.ftd.workforce.workhours.services.SecurityManager;
import org.builderforce.tasks.persistence.enums.RULES;
import org.ftd.workforce.workhours.adapters.IdName;
import org.ftd.workforce.workhours.enums.APP;
import org.ftd.workforce.workhours.services.MenuService;
import org.softwareworkforce.web.mvc.abstracts.AbstractCmd;
import org.softwareworkforce.web.mvc.enums.CRUD;
import org.softwareworkforce.web.mvc.enums.MODEL;
import org.softwareworkforce.web.mvc.enums.MSGS;
import org.softwareworkforce.web.mvc.enums.MVC;
import org.softwareworkforce.web.mvc.interfaces.ICmd;

/**
 *
 * @author Fabio.Dippold
 * @version 1.0.0
 * @since 2020-1-15
 *
 */
public class WorkHourCmd extends AbstractCmd implements ICmd {

    public static final RULES[] permissions = {
        RULES.PROJECT_TEAM,
        RULES.PROJECT_MANAGER,
        RULES.TASK_ADMIN
    };

    @Override
    protected boolean __securityValidate(HttpServletRequest req) {
        return SecurityManager.getInstance().validate(req, permissions);
    }

    @Override
    protected String __add(HttpServletRequest req, HttpServletResponse res) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected String __upd(HttpServletRequest req, HttpServletResponse res) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected String __del(HttpServletRequest req, HttpServletResponse res) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected String __addBuildModel(HttpServletRequest req, HttpServletResponse res) {
        // MENU...
        MenuService.getInstance().buildMenuModel(req);
        //VIEW...
        String nextCmd = "WEB-INF/views/RegisterWork.jsp";
        // MVC...
        req.setAttribute("viewName", "Registrar trabalho");
        //req.setAttribute("url", MVC.URL.getName());
        req.setAttribute("url", "show");
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
        req.setAttribute("activities", findActivities(req, null));
        req.setAttribute("completeness", getCompletenessRange(req));
        req.setAttribute("workhoursday", getWorkHoursDayRange(req));
        
        return nextCmd;
    }

    @Override
    protected String __updBuildModel(HttpServletRequest req, HttpServletResponse res) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected String __delBuildModel(HttpServletRequest req, HttpServletResponse res) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected String __viewBuildModel(HttpServletRequest req, HttpServletResponse res) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected String __lstBuildModel(HttpServletRequest req, HttpServletResponse res) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    // PRIVATE MEMBERS...    
    private List<IdName> findProjects(HttpServletRequest req) {
        List<IdName> lst = new ArrayList();
        
        lst.add(new IdName(null, null));
        lst.add(new IdName(1L, "Catalágo de Produtos"));
        lst.add(new IdName(2L, "Propaga"));
        lst.add(new IdName(3L, "Franquias"));

        return lst;
    }

    // PRIVATE MEMBERS...    
    private List<IdName> findActivities(HttpServletRequest req, Long projectId) {
        List<IdName> lst = new ArrayList();

        lst.add(new IdName(null, null));
        lst.add(new IdName(1L, "Atividade-1"));
        lst.add(new IdName(2L, "Atividade-2"));
        lst.add(new IdName(3L, "Atividade-3"));
        lst.add(new IdName(4L, "Atividade-4"));
        lst.add(new IdName(5L, "Atividade-5"));
        lst.add(new IdName(6L, "Atividade-6"));

        return lst;
    }

    // PRIVATE MEMBERS...    
    private List<IdName> getCompletenessRange(HttpServletRequest req) {
        List<IdName> lst = new ArrayList();

        lst.add(new IdName(0L, "0%"));
        lst.add(new IdName(25L, "25%"));
        lst.add(new IdName(50L, "50%"));
        lst.add(new IdName(75L, "75%"));
        lst.add(new IdName(100L, "100%"));

        return lst;
    }    

    // PRIVATE MEMBERS...    
    private List<IdName> getWorkHoursDayRange(HttpServletRequest req) {
        List<IdName> lst = new ArrayList();

        lst.add(new IdName(1L, "1"));
        lst.add(new IdName(2L, "2"));
        lst.add(new IdName(3L, "3"));
        lst.add(new IdName(4L, "4"));
        lst.add(new IdName(5L, "5"));
        lst.add(new IdName(6L, "6"));
        lst.add(new IdName(7L, "7"));
        lst.add(new IdName(8L, "8"));
        lst.add(new IdName(9L, "9"));
        lst.add(new IdName(10L, "10")); 
        lst.add(new IdName(11L, "11")); 
        lst.add(new IdName(12L, "12")); 
        
        return lst;
    } 
    
}
