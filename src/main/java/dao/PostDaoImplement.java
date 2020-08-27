package dao;

import entity.Post;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

public class PostDaoImplement implements PostDao
{
    @PersistenceContext
    EntityManager em;

    @Override
    @Transactional
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
