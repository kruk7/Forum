package utils;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class EntityManagerConstructor
{
    @PersistenceContext
    EntityManager entityManager;

    @Produces
    @RequestScoped
    public EntityManager createEntityManager()
    {
        return entityManager;
    }
}
