package companies;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Comment;
import models.Company;
import models.User;
import utils.DBUtil;

/**
 * Servlet implementation class CompaniesCommentServlet
 */
@WebServlet(name = "companies/comment", urlPatterns = { "/companies/comment" })
public class CompaniesCommentServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CompaniesCommentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        EntityManager em = DBUtil.createEntityManager();

        User login_user = (User)request.getSession().getAttribute("login_user");
        int company_id=Integer.parseInt(request.getParameter("company_id"));
        Company company=em.find(Company.class,Integer.parseInt(request.getParameter("company_id")));



        Comment c = new Comment();
        c.setUser(login_user);
        c.setCompany(company);
        c.setContent(request.getParameter("content"));

        em.getTransaction().begin();
        em.persist(c);
        em.getTransaction().commit();

        em.close();

        request.setAttribute("company_id",company_id);
        RequestDispatcher rd = request.getRequestDispatcher("/companies/comment_index");
        rd.forward(request, response);



    }

}
