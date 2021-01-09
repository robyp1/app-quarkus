package org.acme.dao;

import org.acme.entities.IEntity;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;

@ApplicationScoped
//@Default
public abstract class DaoManager<T extends IEntity<?>> implements IDao<T> {

    @Inject
    protected EntityManager entityManager;


    public <T> T update(T entity) {
        return entityManager.merge(entity);
    }

    public <T> void delete(T entity) {
        entityManager.remove(entity);
    }

    public <T> T find(Long id, Class<T> theClass) {
        return entityManager.find(theClass, id);
    }

    @Override
    public void flush() {
        entityManager.flush();
        entityManager.clear();
    }

    public <T> void save(T entity) {
        entityManager.persist(entity);
    }

}
