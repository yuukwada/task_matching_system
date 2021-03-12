package reports;

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
import models.Report;
import utils.DBUtil;

/**
 * Servlet implementation class ReportsFavorite_IndexServlet
 */
@WebServlet(name = "reports/favorite_index", urlPatterns = { "/reports/favorite_index" })
public class ReportsFavorite_IndexServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReportsFavorite_IndexServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        EntityManager em=DBUtil.createEntityManager();

        Company login_company = (Company)request.getSession().getAttribute("login_company");

        int page;

        try{
            page = Integer.parseInt(request.getParameter("page"));
        } catch(Exception e) {
            page = 1;
        }



        long favorites_count=(long)em.createNamedQuery("getFavoriteCounts",Long.class)
                                          .setParameter("company",login_company)
                                          .getSingleResult();

        if(favorites_count==0){
            em.close();
        }

        if(favorites_count>0){

           List<Report> favorited_reports =em.createNamedQuery("getFavoritedReports",Report.class)
                                              .setParameter("company",login_company)
                                              .setFirstResult(15*(page-1))
                                              .setMaxResults(15)
                                              .getResultList();
           em.close();
           request.setAttribute("favorited_reports",favorited_reports);
        }



        request.setAttribute("page", page);
        request.setAttribute("favorites_count",favorites_count);


        if(request.getSession().getAttribute("flush") != null) {
            request.setAttribute("flush", request.getSession().getAttribute("flush"));
            request.getSession().removeAttribute("flush");
        }

        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/reports/favorite_index.jsp");
        rd.forward(request, response);
    }


}
