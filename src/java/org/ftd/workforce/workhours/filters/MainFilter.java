package org.ftd.workforce.workhours.filters;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.ftd.workforce.workhours.services.LogService;
import org.softwareworkforce.web.mvc.enums.MSGS;
import org.softwareworkforce.web.mvc.enums.MVC;
import org.softwareworkforce.web.mvc.enums.VIEWS;

/**
 *
 * @author Fabio Tavares Dippold
 * @version 1.0.0
 * @since 2020-1-11
 * 
 */
@WebFilter(filterName = "MainFilter",
        urlPatterns = {"/mvc", "/srv/**", "/WEB-INF/**"})
public class MainFilter implements Filter {

    private static final boolean DEBUG = true;

    private FilterConfig filterConfig = null;

    public MainFilter() {
    }

    /**
     *
     * @param request The servlet request we are processing
     * @param response The servlet response we are creating
     * @param chain The filter chain we are processing
     *
     * @exception IOException if an input/output error occurs
     * @exception ServletException if a servlet error occurs
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        HttpSession session = req.getSession(false);

        boolean isUserAuthorized = false;
        String userId = "";
        String userName = "";
        String userRuleId = "";

        if (session != null) {

            userId = (String) session.getAttribute("userId");
            userName = (String) session.getAttribute("userName");
            userRuleId = (String) session.getAttribute("userRuleId");

            if ((userId != null)
                    && (!userId.equals(""))
                    && (userName != null)
                    && (!userName.equals(""))
                    && (userRuleId != null)
                    && (!userRuleId.equals("")))
            {               
                isUserAuthorized = true;                
            }
            
        }

        if (isUserAuthorized) {
            LogService.getInstance().simpleRecordUserActivity(Long.parseLong(userId), userName, "User","Login autorizado");
            chain.doFilter(request, response);
        } else {
            request.setAttribute(MVC.MSG.getName(), MSGS.INVALID_SESSION.getName());
            req.getRequestDispatcher(VIEWS.LOGIN.getName()).forward(req, res);
        }

    }

    private String readParameter(HttpServletRequest req, String parameterName, String defaultValue) {
        String value = req.getParameter(parameterName);
        if ((value == null) || (value.equals(""))) {
            value = defaultValue;
        }

        return value;
    }

    private boolean isValidaProfile(String profileId, String profilesIds) {
        boolean result = false;
        String[] ids = profilesIds.split(";");
        for (String id : ids) {
            if (id.equals(profileId)) {
                result = true;
                break;
            }
        }

        return result;
    }

    private void killSession(HttpSession session) {
        session.removeAttribute("userId");
        session.removeAttribute("userName");
        session.removeAttribute("userRuleId");
        session.invalidate();
    }

    /**
     * Return the filter configuration object for this filter.
     *
     * @return
     */
    public FilterConfig getFilterConfig() {
        return (this.filterConfig);
    }

    /**
     * Set the filter configuration object for this filter.
     *
     * @param filterConfig The filter configuration object
     */
    public void setFilterConfig(FilterConfig filterConfig) {
        this.filterConfig = filterConfig;
    }

    /**
     * Destroy method for this filter
     */
    @Override
    public void destroy() {
    }

    /**
     * Init method for this filter
     *
     * @param filterConfig
     */
    @Override
    public void init(FilterConfig filterConfig) {
        this.filterConfig = filterConfig;
        if (filterConfig != null) {
            if (DEBUG) {
                log("MainFilter:Initializing filter");
            }
        }
    }

    /**
     * Return a String representation of this object.
     *
     * @return
     */
    @Override
    public String toString() {
        if (filterConfig == null) {
            return ("MainFilter()");
        }
        StringBuilder sb = new StringBuilder("MainFilter(");
        sb.append(filterConfig);
        sb.append(")");
        return (sb.toString());
    }

    public static String getStackTrace(Throwable t) {
        String stackTrace = null;
        try {
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            t.printStackTrace(pw);
            pw.close();
            sw.close();
            stackTrace = sw.getBuffer().toString();
        } catch (Exception ex) {
        }
        return stackTrace;
    }

    public void log(String msg) {
        filterConfig.getServletContext().log(msg);
    }

}
