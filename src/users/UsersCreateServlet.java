package users;

import java.io.IOException;
import java.sql.Date;
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

import models.User;
import utils.DBUtil;
import utils.EncryptUtil;
import validators.UsersValidator;

/**
 * Servlet implementation class UsersCreateServlet
 */
@WebServlet(name = "users/create", urlPatterns = { "/users/create" })
@MultipartConfig()
public class UsersCreateServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UsersCreateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


            EntityManager em=DBUtil.createEntityManager();

            User u = new User();

            u.setName(request.getParameter("name"));
            u.setPhone_number(request.getParameter("phone_number"));
            u.setEmail(request.getParameter("email"));
            u.setPlace_prefecture(request.getParameter("place_prefecture"));
            u.setPlace_address(request.getParameter("place_address"));
            u.setPhone_number(request.getParameter("phone_number"));
            u.setGender(request.getParameter("gender"));
            u.setDelete_flag(0);

            Date birthday = new Date(System.currentTimeMillis());

            birthday = Date.valueOf(request.getParameter("birthday"));
            u.setBirthday(birthday);


            u.setPassword(
                EncryptUtil.getPasswordEncrypt(
                    request.getParameter("password"),
                        (String)this.getServletContext().getAttribute("pepper")
                    )
                );


            Timestamp currentTime = new Timestamp(System.currentTimeMillis());

            u.setCreated_at(currentTime);
            u.setUpdated_at(currentTime);

            if(request.getPart("image").getSize() != 0){
                Part part=(request.getPart("image"));
                String image=this.getFileName(part);
                part.write(getServletContext().getRealPath("/uploaded") + "/" + image);
                u.setImage(image);
            }

            List<String> errors = UsersValidator.validate(u,true,true);
            if(errors.size() > 0) {
                em.close();

                request.setAttribute("_token", request.getSession().getId());
                request.setAttribute("user", u);
                request.setAttribute("errors", errors);

                RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/users/new.jsp");
                rd.forward(request, response);
            } else {

            em.getTransaction().begin();
            em.persist(u);
            em.getTransaction().commit();
            request.getSession().setAttribute("flush", "登録が完了しました。 ～ようこそ～");
            request.getSession().setAttribute("login_user", u);
            em.close();

            response.sendRedirect(request.getContextPath() + "/reports/index");

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
