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
import org.softwareworkforce.web.mvc.enums.VIEWS;
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
        MenuService.getInstance().buildMenuModel(req); 
        boolean securityValidate = SecurityManager.getInstance().validate(req, permissions);        
        String nextCmd;        
        if (!securityValidate) {
            req.setAttribute(MVC.MSG.getName(), MSGS.INVALID_RULE.getName() + this.getClass().getSimpleName());
            nextCmd = APP.URL_SECURITY_LOGOUT.getValue();            
        } else {
            // MENU...
            MenuService.getInstance().buildMenuModel(req);
            // MVC...
            req.setAttribute("viewName", "Registrar horas trabalhadas");
            req.setAttribute("url",MVC.URL.getName());
            req.setAttribute(MVC.CMD.getName(), this.getClass().getSimpleName());
            req.setAttribute(MVC.ACTION.getName(), CRUD.ADD.getName());
            req.setAttribute(MVC.ID.getName(), "0");
            req.setAttribute(MVC.PID.getName(), "0");
            req.setAttribute(MVC.PPID.getName(), "0");
            req.setAttribute(MVC.MSG.getName(), null);
            // FORM...
            req.setAttribute("btnSubmitLabel","Registrar");
            req.setAttribute("btnCancelLabel","Cancelar");
            req.setAttribute("urlToCancel", buildUrl(APP.CMD_HOME.getValue(), MODEL.LST.getName()));
            
            
            req.setAttribute("entity",null);
            req.setAttribute("projects",findProjects(req));
            
            
            nextCmd = "WEB-INF/views/RegisterWork.jsp";
        }
        
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
        
        lst.add(new IdName(1L,"Catalágo de Produtos"));
        lst.add(new IdName(2L,"Propaga"));
        lst.add(new IdName(3L,"Franquias"));
        
        return lst;
    }
    
    
}
