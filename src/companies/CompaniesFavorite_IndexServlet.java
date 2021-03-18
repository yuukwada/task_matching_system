package companies;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Company;
import models.User;
import utils.DBUtil;

/**
 * Servlet implementation class CompaniesFavorite_IndexServlet
 */
@WebServlet(name = "companies/favorite_index", urlPatterns = { "/companies/favorite_index" })
public class CompaniesFavorite_IndexServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CompaniesFavorite_IndexServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        EntityManager em=DBUtil.createEntityManager();

        User login_user = (User)request.getSession().getAttribute("login_user");

        int page;

        try{
            page = Integer.parseInt(request.getParameter("page"));
        } catch(Exception e) {
            page = 1;
        }



        long favorites_count=(long)em.createNamedQuery("getFavoriteCounts_C",Long.class)
                                          .setParameter("user",login_user)
                                          .getSingleResult();

        if(favorites_count==0){
            em.close();
        }

        if(favorites_count>0){

           List<Company> favorited_companies =em.createNamedQuery("getFavoritedCompanies",Company.class)
                                              .setParameter("user",login_user)
                                              .setFirstResult(15*(page-1))
                                              .setMaxResults(15)
                                              .getResultList();
           em.close();
           request.setAttribute("favorited_companies",favorited_companies);
        }



        request.setAttribute("page", page);
        request.setAttribute("favorites_count",favorites_count);


        if(request.getSession().getAttribute("flush") != null) {
            request.setAttribute("flush", request.getSession().getAttribute("flush"));
            request.getSession().removeAttribute("flush");
        }

        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/companies/favorite_index.jsp");
        rd.forward(request, response);

    }



}
