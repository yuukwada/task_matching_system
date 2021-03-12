package reports;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Company;
import models.Favorite;
import models.Report;
import utils.DBUtil;

/**
 * Servlet implementation class ReportsFavorite_DestroyServlet
 */
@WebServlet(name = "reports/favorite_destroy", urlPatterns = { "/reports/favorite_destroy" })
public class ReportsFavorite_DestroyServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReportsFavorite_DestroyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        EntityManager em=DBUtil.createEntityManager();

        Company login_company = (Company)request.getSession().getAttribute("login_company");
        Report report=em.find(Report.class,Integer.parseInt(request.getParameter("report_id")));


        Integer favorite_id=em.createNamedQuery("getFavoriteId",Integer.class)
                               .setParameter("report",report)
                               .setParameter("company",login_company)
                               .getSingleResult();

        Favorite f =em.find(Favorite.class,favorite_id);

        em.getTransaction().begin();
        em.remove(f);
        em.getTransaction().commit();
        em.close();

        response.sendRedirect(request.getContextPath()+"/reports/index");
    }

}
