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
 * Servlet implementation class UsersUpdateServlet
 */
@WebServlet(name = "users/update", urlPatterns = { "/users/update" })
@MultipartConfig()
public class UsersUpdateServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UsersUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String _token = (String)request.getParameter("_token");
        int user_id=(Integer)(request.getSession().getAttribute("user_id"));

        if(_token != null && _token.equals(request.getSession().getId())){

            EntityManager em=DBUtil.createEntityManager();

            User u = em.find(User.class,(Integer)(request.getSession().getAttribute("user_id")));


            u.setName(request.getParameter("name"));
            u.setPhone_number(request.getParameter("phone_number"));
            u.setEmail(request.getParameter("email"));
            u.setPlace_prefecture(request.getParameter("place_prefecture"));
            u.setPlace_address(request.getParameter("place_address"));
            u.setPhone_number(request.getParameter("phone_number"));
            u.setGender(request.getParameter("gender"));

            Date birthday = new Date(System.currentTimeMillis());
            String rd_str = request.getParameter("birthday");
            if(rd_str != null && !rd_str.equals("")) {
                birthday = Date.valueOf(request.getParameter("birthday"));
            }
            u.setBirthday(birthday);


            Boolean passwordCheckFlag = true;
            String password = request.getParameter("password");
            if(password == null || password.equals("")) {
                passwordCheckFlag = false;
            } else {
                u.setPassword(
                        EncryptUtil.getPasswordEncrypt(
                                password,
                                (String)this.getServletContext().getAttribute("pepper")
                                )
                        );
            }


            Timestamp currentTime = new Timestamp(System.currentTimeMillis());

            u.setUpdated_at(currentTime);

            if(request.getPart("image").getSize() != 0){
                Part part=(request.getPart("image"));
                String image=this.getFileName(part);
                part.write(getServletContext().getRealPath("/uploaded") + "/" + image);
                u.setImage(image);
            }

            List<String> errors = UsersValidator.validate(u,true,passwordCheckFlag);
            if(errors.size() > 0) {
                em.close();

                request.setAttribute("_token", request.getSession().getId());
                request.setAttribute("user", u);
                request.setAttribute("errors", errors);

                RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/users/edit.jsp");
                rd.forward(request, response);
            } else {

            em.getTransaction().begin();
            em.getTransaction().commit();
            em.close();

            request.setAttribute("id",user_id);
            RequestDispatcher rd = request.getRequestDispatcher("/reports/index");
            rd.forward(request, response);

            }

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
