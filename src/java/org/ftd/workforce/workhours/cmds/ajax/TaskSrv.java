package org.ftd.workforce.workhours.cmds.ajax;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.builderforce.tasks.persistence.enums.RULES;
import org.ftd.workforce.workhours.adapters.IdName;
import org.ftd.workforce.workhours.services.SecurityManager;
import org.softwareworkforce.web.mvc.abstracts.AbstractAjaxService;
import org.softwareworkforce.web.mvc.abstracts.AbstractCmd;
import org.softwareworkforce.web.mvc.enums.MVC;
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
    public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        if (!SecurityManager.getInstance().validate(req, PERMISSIONS)) {

            Result result = new Result();
            result.setSuccess(false);
            result.addError("0", "Sem permissão para acessar a url=/ajax/" + this.getClass().getSimpleName());
            AbstractAjaxService.doResponseJson(res, result);

        } else {
            String action = AbstractCmd.readParameter(req, MVC.ACTION.getName());
            switch (action) {
                case "find":
                    __find(req, res);
                    break;
                default:
                    AbstractAjaxService.notFoundAction(req, res, action);
                    break;
            }
        }

    }

    private void __find(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        List<IdName> lst = new ArrayList();
        lst.add(new IdName(null, null));
        lst.add(new IdName(1L, "Atividade-1"));
        lst.add(new IdName(2L, "Atividade-2"));
        lst.add(new IdName(3L, "Atividade-3"));
        lst.add(new IdName(4L, "Atividade-4"));
        lst.add(new IdName(5L, "Atividade-5"));
        lst.add(new IdName(6L, "Atividade-6"));
        
        Result result = new Result();
        result.setData(lst);
        AbstractAjaxService.doResponseJson(res, result);
    }
}
