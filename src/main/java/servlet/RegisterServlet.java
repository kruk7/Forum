package servlet;

import dao.UserDao;
import entity.User;

import javax.inject.Inject;
import javax.persistence.NoResultException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "RegisterServlet", value = "/register")
public class RegisterServlet extends HttpServlet
{
    @Inject
    UserDao userDao;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String login = request.getParameter("login");
        String pass = request.getParameter("password");
        String pass2 = request.getParameter("password2");
        if ( login!=null && pass!=null && pass2!=null && pass.equals(pass2) && !"".equals(pass))
        {
            try
            {
                userDao.getByLogin(login);
                request.setAttribute("message", "This login already exist");
                doGet(request, response);
            } catch (NoResultException nre)
            {
                User user = new User();
                user.setLogin(login);
                user.setPassword(pass);
                if (userDao.addUser(user))
                    response.sendRedirect(request.getContextPath() + "/index");
                else{
                    request.setAttribute("message", "Error bad login data");
                    doGet(request,response);
                }
            }
        }
        else
        {
            request.setAttribute("message", "Error, Bad login or Password");
            doGet(request, response);
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        request.getRequestDispatcher("/WEB-INF/view/register.jsp").forward(request, response);
    }
}
