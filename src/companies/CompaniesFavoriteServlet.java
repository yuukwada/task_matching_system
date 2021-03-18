package companies;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Company;
import models.Favorite_C;
import models.User;
import utils.DBUtil;

/**
 * Servlet implementation class CompaniesFavoriteServlet
 */
@WebServlet(name = "companies/favorite", urlPatterns = { "/companies/favorite" })
public class CompaniesFavoriteServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CompaniesFavoriteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        EntityManager em = DBUtil.createEntityManager();

        User login_user = (User)request.getSession().getAttribute("login_user");
        Company company=em.find(Company.class,Integer.parseInt(request.getParameter("company_id")));



        Favorite_C f = new Favorite_C();
        f.setUser(login_user);
        f.setCompany(company);

        em.getTransaction().begin();
        em.persist(f);
        em.getTransaction().commit();

        em.close();


        response.sendRedirect(request.getContextPath()+"/companies/index");


    }

}
