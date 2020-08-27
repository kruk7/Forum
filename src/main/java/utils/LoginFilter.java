package utils;

import dao.UserDao;
import entity.User;

import javax.inject.Inject;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "LoginFilter", value = "/*")
public class LoginFilter implements Filter
{
    @Inject
    UserDao userDao;

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException
    {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        request.setCharacterEncoding("UTF-8");

        String login = request.getRemoteUser();
        if (login != null)
        {
            User user = (User) request.getSession().getAttribute("user");
            if (user == null)
            {
                user = userDao.getByLogin(login);
                request.getSession().setAttribute("user", user);
            }
        }
        chain.doFilter(req, resp);
    }
    public void destroy() { }
    public void init(FilterConfig config) throws ServletException { }
}
