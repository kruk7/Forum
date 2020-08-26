package dao;

import entity.Post;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class PostDaoImplement implements PostDao
{
    @PersistenceContext
    EntityManager em;

    @Override
    public boolean addPost(Post post)
    {
        try
        {
            em.persist(post);
            return true;
        } catch (Exception e)
        {
            e.printStackTrace();
            return false;
        }
    }
}
