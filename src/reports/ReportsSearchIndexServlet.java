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

import models.Report;
import utils.DBUtil;

/**
 * Servlet implementation class ReportsSearchIndexServlet
 */
@WebServlet(name = "reports/searchindex", urlPatterns = { "/reports/searchindex" })
public class ReportsSearchIndexServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReportsSearchIndexServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        EntityManager em = DBUtil.createEntityManager();

        String place_prefecture=request.getParameter("place_prefecture");
        String industry=request.getParameter("industry");
        int budget;
        budget=Integer.parseInt(request.getParameter("budget"));

        /* int budget=Integer.parseInt(request.getParameter("budget"));

           Integer budget=Integer.parseInt(request.getParameter("budget"));  */



        int page;
        try{
            page = Integer.parseInt(request.getParameter("page"));
        } catch(Exception e) {
            page = 1;
        }

        if(!place_prefecture.equals("") && !industry.equals("") && budget !=0 ){
            List<Report> reports = em.createNamedQuery("searchReport_budget_place_industry", Report.class)
                                  .setParameter("place_prefecture",place_prefecture)
                                  .setParameter("industry",industry)
                                  .setParameter("budget",budget)
                                  .setFirstResult(15 * (page - 1))
                                  .setMaxResults(15)
                                  .getResultList();
            long reports_count = (long)em.createNamedQuery("getReportsCount", Long.class)
                    .getSingleResult();

            em.close();
            request.setAttribute("reports", reports);
            request.setAttribute("reports_count", reports_count);
            request.setAttribute("page", page);
            if(request.getSession().getAttribute("flush") != null) {
            request.setAttribute("flush", request.getSession().getAttribute("flush"));
            request.getSession().removeAttribute("flush");
            }

            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/reports/searchindex.jsp");
            rd.forward(request, response);

        }else if(!place_prefecture.equals("") && !industry.equals("")){
            List<Report> reports = em.createNamedQuery("searchReport_place_industry", Report.class)
                                .setParameter("place_prefecture",place_prefecture)
                                .setParameter("industry",industry)
                                .setFirstResult(15 * (page - 1))
                                .setMaxResults(15)
                                .getResultList();
            long reports_count = (long)em.createNamedQuery("getReportsCount", Long.class)
                    .getSingleResult();
            em.close();

            request.setAttribute("reports", reports);
            request.setAttribute("reports_count", reports_count);
            request.setAttribute("page", page);
            if(request.getSession().getAttribute("flush") != null) {
            request.setAttribute("flush", request.getSession().getAttribute("flush"));
            request.getSession().removeAttribute("flush");
            }

            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/reports/searchindex.jsp");
            rd.forward(request, response);

        }else if(!place_prefecture.equals("") && budget !=0){
            List<Report> reports = em.createNamedQuery("searchReport_budget_place", Report.class)
                                .setParameter("place_prefecture",place_prefecture)
                                .setParameter("budget",budget)
                                .setFirstResult(15 * (page - 1))
                                .setMaxResults(15)
                                .getResultList();
            long reports_count = (long)em.createNamedQuery("getReportsCount", Long.class)
                    .getSingleResult();

            em.close();
            request.setAttribute("reports", reports);
            request.setAttribute("reports_count", reports_count);
            request.setAttribute("page", page);
            if(request.getSession().getAttribute("flush") != null) {
            request.setAttribute("flush", request.getSession().getAttribute("flush"));
            request.getSession().removeAttribute("flush");
            }

            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/reports/searchindex.jsp");
            rd.forward(request, response);

        }else if(!industry.equals("") && budget !=0){
            List<Report> reports = em.createNamedQuery("searchReport_budget_industry", Report.class)
                                .setParameter("industry",industry)
                                .setParameter("budget",budget)
                                .setFirstResult(15 * (page - 1))
                                .setMaxResults(15)
                                .getResultList();
            long reports_count = (long)em.createNamedQuery("getReportsCount", Long.class)
                    .getSingleResult();

            em.close();

            request.setAttribute("reports", reports);
            request.setAttribute("reports_count", reports_count);
            request.setAttribute("page", page);
            if(request.getSession().getAttribute("flush") != null) {
            request.setAttribute("flush", request.getSession().getAttribute("flush"));
            request.getSession().removeAttribute("flush");
            }

            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/reports/searchindex.jsp");
            rd.forward(request, response);

        }else if(!place_prefecture.equals("")){
            List<Report> reports = em.createNamedQuery("searchReport_place", Report.class)
                                .setParameter("place_prefecture",place_prefecture)
                                .setFirstResult(15 * (page - 1))
                                .setMaxResults(15)
                                .getResultList();
            long reports_count = (long)em.createNamedQuery("getReportsCount", Long.class)
                    .getSingleResult();
            em.close();

            request.setAttribute("reports", reports);
            request.setAttribute("reports_count", reports_count);
            request.setAttribute("page", page);
            if(request.getSession().getAttribute("flush") != null) {
            request.setAttribute("flush", request.getSession().getAttribute("flush"));
            request.getSession().removeAttribute("flush");
            }

            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/reports/searchindex.jsp");
            rd.forward(request, response);

        }else if(!industry.equals("") ){
            List<Report> reports = em.createNamedQuery("searchReport_industry", Report.class)
                                .setParameter("industry",industry)
                                .setFirstResult(15 * (page - 1))
                                .setMaxResults(15)
                                .getResultList();
            long reports_count = (long)em.createNamedQuery("getReportsCount", Long.class)
                    .getSingleResult();
            em.close();

            request.setAttribute("reports", reports);
            request.setAttribute("reports_count", reports_count);
            request.setAttribute("page", page);
            if(request.getSession().getAttribute("flush") != null) {
            request.setAttribute("flush", request.getSession().getAttribute("flush"));
            request.getSession().removeAttribute("flush");
            }

            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/reports/searchindex.jsp");
            rd.forward(request, response);

        }else if(budget != 0){
            List<Report> reports = em.createNamedQuery("searchReport_budget", Report.class)
                                .setParameter("budget",budget)
                                .setFirstResult(15 * (page - 1))
                                .setMaxResults(15)
                                .getResultList();
            long reports_count = (long)em.createNamedQuery("getReportsCount", Long.class)
                    .getSingleResult();
            em.close();

            request.setAttribute("reports", reports);
            request.setAttribute("reports_count", reports_count);
            request.setAttribute("page", page);
            if(request.getSession().getAttribute("flush") != null) {
            request.setAttribute("flush", request.getSession().getAttribute("flush"));
            request.getSession().removeAttribute("flush");
            }

            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/reports/searchindex.jsp");
            rd.forward(request, response);
        }else{
            response.sendRedirect(request.getContextPath()+"/reports/search");
        }



    }


}
