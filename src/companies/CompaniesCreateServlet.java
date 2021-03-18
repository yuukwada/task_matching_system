package companies;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import models.Company;
import utils.DBUtil;
import utils.EncryptUtil;
import validators.CompaniesValidator;

/**
 * Servlet implementation class CompaniesCreateServlet
 */
@WebServlet(name = "companies/create", urlPatterns = { "/companies/create" })
@MultipartConfig()
public class CompaniesCreateServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CompaniesCreateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }



    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


            EntityManager em=DBUtil.createEntityManager();

            Company c = new Company();

            c.setName(request.getParameter("name"));
            c.setPhone_number(request.getParameter("phone_number"));
            c.setEmail(request.getParameter("email"));
            c.setPlace_prefecture(request.getParameter("place_prefecture"));
            c.setPlace_address(request.getParameter("place_address"));
            c.setPhone_number(request.getParameter("phone_number"));
            c.setIndustry(request.getParameter("industry"));
            c.setBudget(Integer.parseInt(request.getParameter("budget")));
            c.setAchieve(request.getParameter("achieve"));
            c.setDelete_flag(0);


            c.setPassword(
                EncryptUtil.getPasswordEncrypt(
                    request.getParameter("password"),
                        (String)this.getServletContext().getAttribute("pepper")
                    )
                );


            Timestamp currentTime = new Timestamp(System.currentTimeMillis());

            c.setCreated_at(currentTime);
            c.setUpdated_at(currentTime);

            if(request.getPart("image").getSize() != 0){
                Part part=(request.getPart("image"));
                String image=this.getFileName(part);
                part.write(getServletContext().getRealPath("/uploaded") + "/" + image);
                c.setImage(image);

            }

            if(request.getPart("achieve_image1").getSize() != 0){
                Part part1=(request.getPart("achieve_image1"));
                String achieve_image1=this.getFileName(part1);
                part1.write(getServletContext().getRealPath("/uploaded") + "/" + achieve_image1);
                c.setAchieve_image1(achieve_image1);
            }

            if(request.getPart("achieve_image2").getSize() != 0){
                Part part2=(request.getPart("achieve_image2"));
                String achieve_image2=this.getFileName(part2);
                part2.write(getServletContext().getRealPath("/uploaded") + "/" + achieve_image2);
                c.setAchieve_image2(achieve_image2);
            }

            if(request.getPart("achieve_image3").getSize() != 0){
                Part part3=(request.getPart("achieve_image3"));
                String achieve_image3=this.getFileName(part3);
                part3.write(getServletContext().getRealPath("/uploaded") + "/" + achieve_image3);
                c.setAchieve_image3(achieve_image3);
            }

            List<String> errors = CompaniesValidator.validate(c,true);
            if(errors.size() > 0) {
                em.close();

                request.setAttribute("_token", request.getSession().getId());
                request.setAttribute("company", c);
                request.setAttribute("errors", errors);

                RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/companies/new.jsp");
                rd.forward(request, response);
            } else {


            em.getTransaction().begin();
            em.persist(c);
            em.getTransaction().commit();
            request.getSession().setAttribute("flush", "登録が完了しました。 ～ようこそ～");
            request.getSession().setAttribute("login_company", c);
            em.close();

            response.sendRedirect(request.getContextPath() + "/companies/index");

            }

        }

    private String getFileName(Part part) {
        String name = null;
        for (String dispotion : part.getHeader("Content-Disposition").split(";")) {
            if (dispotion.trim().startsWith("filename")) {
                name = dispotion.substring(dispotion.indexOf("=") + 1).replace("\"", "").trim();
                name = name.substring(name.lastIndexOf("\\") + 1);
                break;
            }
        }
        return name;
    }


}
