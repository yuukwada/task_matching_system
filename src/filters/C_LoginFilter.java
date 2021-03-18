package filters;

import java.io.IOException;

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

import models.Company;
import models.User;

/**
 * Servlet Filter implementation class LoginFilter
 */
@WebFilter("/*")
public class C_LoginFilter implements Filter {

    /**
     * Default constructor.
     */
    public C_LoginFilter() {
    }

    /**
     * @see Filter#destroy()
     */
    public void destroy() {
    }



    /**
     * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
     */
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        String context_path = ((HttpServletRequest)request).getContextPath();
        String servlet_path = ((HttpServletRequest)request).getServletPath();

        if(!servlet_path.matches("/css.*")) {
            HttpSession session = ((HttpServletRequest)request).getSession();

                Company c = (Company)session.getAttribute("login_company");
                User u = (User)session.getAttribute("login_user");


                if(u == null && c == null) {

                    if(!servlet_path.equals("/login") && !servlet_path.equals("/login/company_login") && !servlet_path.equals("/login/user_login")
                            && !servlet_path.equals("/users/new") && !servlet_path.equals("/companies/new")
                            && !servlet_path.equals("/users/create") && !servlet_path.equals("/companies/create")) {
                        ((HttpServletResponse)response).sendRedirect(context_path + "/login");
                        return;
                    }

                }

                if( c != null ) {

                    if(!servlet_path.equals("/companies/index") && !servlet_path.equals("/reports/index") &&
                       !servlet_path.equals("/companies/new") && !servlet_path.equals("/companies/show") &&
                       !servlet_path.equals("/companies/edit") && !servlet_path.equals("/companies/update") &&
                       !servlet_path.equals("/companies/create") && !servlet_path.equals("/companies/destroy") &&
                       !servlet_path.equals("/reports/favorite") && !servlet_path.equals("/reports/favorite_index") &&
                       !servlet_path.equals("/reports/favorite_destroy") && !servlet_path.equals("/reports/search") &&
                       !servlet_path.equals("/reports/search_index") && !servlet_path.equals("/companies/search") &&
                       !servlet_path.equals("/companies/search_index")) {
                        session.removeAttribute("login_company");
                        ((HttpServletResponse)response).sendRedirect(context_path + "/login");
                        return;
                    }

                }

                if( u != null ) {

                    if(!servlet_path.equals("/users/shows") && !servlet_path.equals("/users/new") && !servlet_path.equals("/users/destroy") &&
                       !servlet_path.equals("/users/create") && !servlet_path.equals("/users/edit") &&
                       !servlet_path.equals("/users/update") && !servlet_path.equals("/reports/new") &&
                       !servlet_path.equals("/reports/create") && !servlet_path.equals("/reports/edit") &&
                       !servlet_path.equals("/reports/update") && !servlet_path.equals("/companies/index") &&
                       !servlet_path.equals("/companies/favorite_destroy") && !servlet_path.equals("/companies/favorite") &&
                       !servlet_path.equals("/companies/favorite_index") && !servlet_path.equals("/companies/search") &&
                       !servlet_path.equals("/companies/comment_index") && !servlet_path.equals("/companies/comment_show") &&
                       !servlet_path.equals("/companies/comment") && !servlet_path.equals("/companies/search_index") &&
                       !servlet_path.equals("/reports/self_index") && !servlet_path.equals("/reports/index") &&
                       !servlet_path.equals("/reports/search") && !servlet_path.equals("/reports/search_index")){

                        session.removeAttribute("login_user");
                        ((HttpServletResponse)response).sendRedirect(context_path + "/login");
                        return;
                    }

                }

        }

        chain.doFilter(request, response);
    }

    /**
     * @see Filter#init(FilterConfig)
     */
    public void init(FilterConfig fConfig) throws ServletException {
    }

}