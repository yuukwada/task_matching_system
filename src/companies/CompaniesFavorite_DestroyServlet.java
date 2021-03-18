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
 * Servlet implementation class CompaniesFavorite_DestroyServlet
 */
@WebServlet(name = "companies/favorite_destroy", urlPatterns = { "/companies/favorite_destroy" })
public class CompaniesFavorite_DestroyServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CompaniesFavorite_DestroyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        EntityManager em=DBUtil.createEntityManager();

        User login_user = (User)request.getSession().getAttribute("login_user");
        Company company=em.find(Company.class,Integer.parseInt(request.getParameter("company_id")));


        Integer favorite_id=em.createNamedQuery("getFavoriteId_C",Integer.class)
                               .setParameter("company",company)
                               .setParameter("user",login_user)
                               .getSingleResult();

        Favorite_C f =em.find(Favorite_C.class,favorite_id);

        em.getTransaction().begin();
        em.remove(f);
        em.getTransaction().commit();
        em.close();

        response.sendRedirect(request.getContextPath()+"/companies/index");

    }

}
