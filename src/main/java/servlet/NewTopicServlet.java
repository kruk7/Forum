package servlet;

import dao.TopicDao;
import entity.Topic;
import entity.User;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@WebServlet(name = "NewTopicServlet", value = "/new-topic")
public class  NewTopicServlet extends HttpServlet
{
    @Inject
    TopicDao topicDao;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        if (!"".equals(title) && !"".equals(content))
        {
            Timestamp time = Timestamp.valueOf(LocalDateTime.now());
            User logged = (User)request.getSession().getAttribute("user");
            Topic topic = new Topic();
            topic.setUser(logged);
            topic.setDate(time);
            topic.setTitle(title);
            topic.setContent(content);
            if (topicDao.addTopic(topic))
                response.sendRedirect(request.getContextPath() + "/topic?id=" + topic.getId());
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        request.getRequestDispatcher("/WEB-INF/view/new-topic.jsp").forward(request, response);
    }
}
