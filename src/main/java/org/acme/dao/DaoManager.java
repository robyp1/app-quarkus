package org.acme.dao;

import org.acme.entities.IEntity;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;

@ApplicationScoped
@Default
public abstract class DaoManager<T extends IEntity<?>> implements IDao<T> {

    @Inject
    private EntityManager entityManager;


    public <T> T update(T entity) {
        return entityManager.merge(entity);
    }

    public <T> void delete(T entity) {
        entityManager.remove(entity);
    }

    public <T> T selectSingleResult(String sql, Class<T> theClass) {
        return entityManager.createQuery(sql, theClass).getSingleResult();
    }

    @Override
    public void flush() {
        entityManager.flush();
    }

    public <T> void save(T entity) {
        entityManager.persist(entity);
    }

}
