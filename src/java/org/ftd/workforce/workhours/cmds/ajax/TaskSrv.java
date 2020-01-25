package org.ftd.workforce.workhours.cmds.ajax;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.builderforce.tasks.persistence.enums.RULES;
import org.ftd.workforce.workhours.adapters.IdNameAdapter;
import org.ftd.workforce.workhours.services.SecurityManager;
import org.softwareworkforce.web.mvc.abstracts.AbstractAjaxService;
import org.softwareworkforce.web.mvc.interfaces.IAjaxService;
import org.softwareworkforce.web.mvc.results.Result;

/**
 *
 * @author Fabio Tavares Dippold
 * @version 1.0.0
 * @since 2020-1-24
 *
 */
public class TaskSrv extends AbstractAjaxService implements IAjaxService {

    public static final RULES[] PERMISSIONS = {
        RULES.PROJECT_TEAM,
        RULES.PROJECT_MANAGER,
        RULES.TASK_ADMIN
    };

    @Override
    public boolean securityValidated(HttpServletRequest req) {
        return SecurityManager.getInstance().validate(req, PERMISSIONS);
    }    

    public void find(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        List<IdNameAdapter> lst = new ArrayList();
        lst.add(new IdNameAdapter(null, null));
        lst.add(new IdNameAdapter(1L, "Atividade-1"));
        lst.add(new IdNameAdapter(2L, "Atividade-2"));
        lst.add(new IdNameAdapter(3L, "Atividade-3"));
        lst.add(new IdNameAdapter(4L, "Atividade-4"));
        lst.add(new IdNameAdapter(5L, "Atividade-5"));
        lst.add(new IdNameAdapter(6L, "Atividade-6"));
        
        Result result = new Result();
        result.setData(lst);
        AbstractAjaxService.doResponseJson(res, result);
    }


}
