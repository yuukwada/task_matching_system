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
 * Servlet implementation class ReportsFavoriteServlet
 */
@WebServlet(name = "reports/favorite", urlPatterns = { "/reports/favorite" })
public class ReportsFavoriteServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReportsFavoriteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        EntityManager em = DBUtil.createEntityManager();

        Company login_company = (Company)request.getSession().getAttribute("login_company");
        Report report=em.find(Report.class,Integer.parseInt(request.getParameter("report_id")));



        Favorite f = new Favorite();
        f.setCompany(login_company);
        f.setReport(report);

        em.getTransaction().begin();
        em.persist(f);
        em.getTransaction().commit();

        em.close();


        response.sendRedirect(request.getContextPath()+"/reports/index");

    }

}
