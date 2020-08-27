package servlet;

import dao.PostDao;
import dao.TopicDao;
import entity.Post;
import entity.Topic;
import entity.User;

import javax.inject.Inject;
import javax.jws.soap.SOAPBinding;
import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@WebServlet(name = "TopicServlet", value = "/topic")
public class TopicServlet extends HttpServlet
{
    @Inject
    PostDao postDao;
    @Inject
    TopicDao topicDao;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String content = request.getParameter("content");
        String stringId = request.getParameter("id");
        if (content != null && stringId != null)
        {
            User user = (User) request.getSession().getAttribute("user");
            Topic topic = topicDao.getSingleTopic(Long.parseLong(stringId));
            Post post = new Post();
            post.setContent(content);
            post.setDate(Timestamp.valueOf(LocalDateTime.now()));
            post.setUser(user);
            post.setTopic(topic);
            postDao.addPost(post);
        }
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String stringId = request.getParameter("id");
        if (stringId != null)
        {
            Topic topic = topicDao.getSingleTopic(Long.parseLong(stringId));
            request.setAttribute("topic", topic);
            request.getRequestDispatcher("/WEB-INF/view/topic.jsp").forward(request, response);
        }
        else
            response.sendRedirect(request.getContextPath() + "/");
    }
}
