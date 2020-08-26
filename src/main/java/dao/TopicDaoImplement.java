package dao;

import entity.Topic;

import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@RequestScoped
public class TopicDaoImplement implements TopicDao
{
    @PersistenceContext
    EntityManager em;

    @Override
    public List<Topic> getAllTopics()
    {
        List<Topic> topicList = em.createQuery("SELECT t FROM Topic t").getResultList();
        return topicList;
    }

    @Override
    public Topic getSingleTopic(Long id)
    {
        Topic topic = em.find(Topic.class, id);
        return topic;
    }

    @Override
    @Transactional
    public boolean addTopic(Topic topic)
    {
        try
        {
            em.persist(topic);
            return true;
        } catch (Exception e)
        {
            e.printStackTrace();
            return false;
        }
    }
}
