package dao;

import entity.Role;
import entity.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

public class UserDaoImplement implements UserDao
{
    @PersistenceContext
    EntityManager em;

    @Override
    public User getByLogin(String login)
    {
        TypedQuery<User> query = em.createQuery("SELECT u FROM User u WHERE u.login = :login", User.class);
        query.setParameter("login", login);
        User user =  query.getSingleResult();
        return user;
    }

    @Override
    @Transactional
    public boolean addUser(User user)
    {
        Role role = new Role();
        role.setLogin(user.getLogin());
        role.setRole(USER_ROLE);
        try
        {
            em.persist(user);
            em.persist(role);
            return true;
        } catch (Exception e)
        {
            e.printStackTrace();
            return false;
        }
    }
}
