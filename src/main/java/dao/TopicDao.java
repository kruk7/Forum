package dao;

import entity.Topic;

import java.util.List;

public interface TopicDao
{
    public List<Topic> getAllTopics();
    public Topic getSingleTopic(Long id);
    public boolean addTopic(Topic topic);
}
