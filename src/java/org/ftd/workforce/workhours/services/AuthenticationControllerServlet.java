package org.ftd.workforce.workhours.services;

import java.io.IOException;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.builderforce.tasks.persistence.daos.UserDAO;
import org.builderforce.tasks.persistence.entities.User;
import org.ftd.workforce.workhours.enums.APP;
import org.softwareworkforce.web.mvc.enums.MODEL;
import org.softwareworkforce.web.mvc.enums.MSGS;
import org.softwareworkforce.web.mvc.enums.MVC;
import org.softwareworkforce.web.mvc.enums.VIEWS;

/**
 *
 * @author Fabio Tavares Dippold
 * @version 29/012/2016
 *
 */
@WebServlet(name = "AuthenticationServlet", urlPatterns = {"/signin"})
public class AuthenticationControllerServlet extends HttpServlet {

    private static final long serialVersionUID = 469878074894648120L;
    final String PERSISTENCE_UNIT_NAME = "TasksPU";

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

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        String email = request.getParameter("email");
        String passwd = request.getParameter("passwd");

        User user;

        if ((email != null) && (passwd != null)) {
            
            user = this.findUser(email, passwd);
            
            if ((user != null) && (!user.getIsBlocked())) {

                HttpSession session = request.getSession(true);
                session.setAttribute("userId", Long.toString(user.getId()));
                session.setAttribute("userName", user.getName());
                session.setAttribute("userRuleId", Long.toString(user.getRuleId()));

                request.getRequestDispatcher( buildUrl(APP.CMD_HOME.getValue(),MODEL.LST.getName()) ).forward(request, response);
                
            } else {
                
                request.setAttribute(MVC.MSG.getName(), MSGS.INVALID_PASSWD.getName());
                request.getRequestDispatcher(VIEWS.LOGIN.getName()).forward(request, response);
                
            }
        } else {
            
            request.setAttribute(MVC.MSG.getName(),MSGS.PASSWD_REQUERED.getName());
            request.getRequestDispatcher(VIEWS.LOGIN.getName()).forward(request, response);
        
        }
    }

    private String buildUrl(String cmd, String action) {
        StringBuilder out = new StringBuilder(MVC.URL.getName());
        out.append("?");
        out.append(MVC.CMD.getName());
        out.append("=");
        out.append(cmd);
        out.append("&");
        out.append(MVC.ACTION.getName());
        out.append("=");
        out.append(action);
        
        return out.toString();
    }

    private User findUser(String email, String passwd) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(APP.PERSISTENCE_UNIT.getValue());
        UserDAO dao = new UserDAO(factory);
        User user;
        try {
            user = dao.findUser(email, passwd);
        } catch (NoResultException e) {
            user = null;
        }

        return user;
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
