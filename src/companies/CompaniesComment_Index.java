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
 * Servlet implementation class CompaniesComment_Index
 */
@WebServlet(name = "companies/comment_index", urlPatterns = { "/companies/comment_index" })
public class CompaniesComment_Index extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CompaniesComment_Index() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        EntityManager em=DBUtil.createEntityManager();

        int company_id=Integer.parseInt(request.getParameter("company_id"));

        Company company=em.find(Company.class,company_id);

        int page;

        try{
            page = Integer.parseInt(request.getParameter("page"));
        } catch(Exception e) {
            page = 1;
        }



        long comment_count=(long)em.createNamedQuery("getCommentCounts",Long.class)
                                          .setParameter("company",company)
                                          .getSingleResult();

        if(comment_count==0){
            em.close();
        }

        if(comment_count>0){

           List<String> comments =em.createNamedQuery("getComments",String.class)
                                              .setParameter("company",company)
                                              .setFirstResult(15*(page-1))
                                              .setMaxResults(15)
                                              .getResultList();

           List<User> users =em.createNamedQuery("getComment_Users",User.class)
                                              .setParameter("company",company)
                                              .setFirstResult(15*(page-1))
                                              .setMaxResults(15)
                                              .getResultList();

           em.close();
           request.setAttribute("comments",comments);
           request.setAttribute("users",users);
           request.setAttribute("company_id",company_id);
        }



        request.setAttribute("page", page);
        request.setAttribute("comment_count",comment_count);


        if(request.getSession().getAttribute("flush") != null) {
            request.setAttribute("flush", request.getSession().getAttribute("flush"));
            request.getSession().removeAttribute("flush");
        }

        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/companies/comment_index.jsp");
        rd.forward(request, response);


    }



    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        EntityManager em=DBUtil.createEntityManager();

        int company_id=Integer.parseInt(request.getParameter("company_id"));

        Company company=em.find(Company.class,company_id);

        int page;

        try{
            page = Integer.parseInt(request.getParameter("page"));
        } catch(Exception e) {
            page = 1;
        }



        long comment_count=(long)em.createNamedQuery("getCommentCounts",Long.class)
                                          .setParameter("company",company)
                                          .getSingleResult();

        if(comment_count==0){
            em.close();
        }

        if(comment_count>0){

           List<String> comments =em.createNamedQuery("getComments",String.class)
                                              .setParameter("company",company)
                                              .setFirstResult(15*(page-1))
                                              .setMaxResults(15)
                                              .getResultList();

           List<User> users =em.createNamedQuery("getComment_Users",User.class)
                                              .setParameter("company",company)
                                              .setFirstResult(15*(page-1))
                                              .setMaxResults(15)
                                              .getResultList();

           em.close();
           request.setAttribute("comments",comments);
           request.setAttribute("users",users);
           request.setAttribute("company_id",company_id);
        }



        request.setAttribute("page", page);
        request.setAttribute("comment_count",comment_count);


        if(request.getSession().getAttribute("flush") != null) {
            request.setAttribute("flush", request.getSession().getAttribute("flush"));
            request.getSession().removeAttribute("flush");
        }

        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/companies/comment_index.jsp");
        rd.forward(request, response);


    }


}
