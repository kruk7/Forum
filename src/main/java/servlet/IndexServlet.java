package servlet;

import dao.TopicDao;
import entity.Topic;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "IndexServlet", value = "/index")
public class IndexServlet extends HttpServlet
{
    @Inject
    TopicDao topicDao;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        List<Topic> topics = topicDao.getAllTopics();
        request.setAttribute("topic", topics);
        request.getRequestDispatcher("/WEB-INF/view/index.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    { doGet(request, response); }
}
