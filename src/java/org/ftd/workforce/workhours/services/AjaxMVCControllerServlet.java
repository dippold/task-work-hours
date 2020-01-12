package org.ftd.workforce.workhours.services;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Fabio Tavares Dippold
 * @version 3.0.4 - 30/08/2017
 *
 */
@WebServlet(name = "AjaxMVCControllerServlet", urlPatterns = {"/ajax"}, initParams = {
    @WebInitParam(name = "mvcAjaxObjectPackage", value = "org.ftd.builderforce.easyservice.web.mvc.ajax")
})
public class AjaxMVCControllerServlet extends HttpServlet {

    private static final long serialVersionUID = 596620210605010358L;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param req
     * @param res
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        res.setCharacterEncoding("UTF-8");
//        try {
//            String MVCClass = this.readParameter(req, "class","");
//            String classMVCPackage = getInitParameter("mvcAjaxObjectPackage");
//            Class theAjaxMVCClassName = Class.forName(classMVCPackage + "." + MVCClass);
//            IAjaxMVC theClassAjaxMVCInstance = (IAjaxMVC) theAjaxMVCClassName.newInstance();
//            theClassAjaxMVCInstance.execute(req, res);
//        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
//            try (PrintWriter out = res.getWriter()) {
//                res.setContentType("application/json");
//                String theClass = this.readParameter(req, "class", "");
//                String theCmd = this.readParameter(req, "do", "null");
//                SimpleResult result = new SimpleResult();
//                StringBuilder sb = new StringBuilder("Não encontrei a Classe AJAX: ");
//                sb.append(theClass);
//                sb.append(" invocando o Método: ");
//                sb.append(theCmd);
//                
//                result.setSuccess(false);
//                result.setCount(0);
//                result.setData(null);
//                List erros = new ArrayList<>();
//                erros.add(new Error("ERRO NÍVEL-1 MVC", sb.toString()));
//                result.setErrors(erros);
//                Gson gson = new Gson();
//                out.println(gson.toJson(result));
//                out.flush();
//                out.close();
//            }
//        }
    }

    protected String readParameter(HttpServletRequest req, String parameterName, String defaultValue) {
        String value = req.getParameter(parameterName);
        if ((value == null) || (value.equals(""))) {
            value = defaultValue;
        }

        return value;
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
