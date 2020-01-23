package org.ftd.workforce.workhours.cmds.ajax;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.builderforce.tasks.persistence.enums.RULES;
import static org.softwareworkforce.web.mvc.abstracts.AbstractCmd.readParameter;
import org.softwareworkforce.web.mvc.enums.MVC;
import org.softwareworkforce.web.mvc.results.Result;
import org.ftd.workforce.workhours.services.SecurityManager;

/**
 *
 * @author Fabio Tavares Dippold
 * @version 1.0.0
 * @since 2020-1-20
 *
 */
@WebServlet(name = "ActivityAjaxService", urlPatterns = {"/srv/task"})
public class TaskService extends HttpServlet {

    public static final RULES[] permissions = {
        RULES.PROJECT_TEAM,
        RULES.PROJECT_MANAGER,
        RULES.TASK_ADMIN
    };

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        if (!SecurityManager.getInstance().validate(request, permissions)) {

            Result result = new Result();
            result.setSuccess(false);
            result.addError("0", "Sem permissão para acessar a url=/srv/task");
            this.doResponseJson(response, result);
            
        } else {
            String action = readParameter(request, MVC.ACTION.getName());
            switch (action) {
                case "findActivities":
                    findActivities(request, response);
                    break;
                default:
                    __notFoundAction(request, response);
                    break;
            }
        }

    }

    private void __notFoundAction(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = readParameter(request, MVC.ACTION.getName());
        Result result = new Result();
        result.setSuccess(false);
        result.addError("0", "Não encontrei a task=" + action);

        this.doResponseJson(response, result);
    }

    private void findActivities(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String id = readParameter(request, MVC.ID.getName());
        Result result = new Result();

        this.doResponseJson(response, result);
    }

    private void doResponseJson(HttpServletResponse response, Result result) throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        Gson gson = new Gson();
        out.print(gson.toJson(result));
        out.flush();
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
