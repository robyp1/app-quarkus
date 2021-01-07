package org.acme.daoLambda;

import org.acme.entities.IEntity;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.function.BiFunction;
import java.util.function.Supplier;

@ApplicationScoped
public class DaoManagerLambda {

    @Inject
    protected EntityManager entityManager;


    public <I> IEntity<I> update(Supplier<IEntity<I>> entity) {
        return entityManager.merge(entity.get());
    }

    public void delete(IEntity entity) {
        entityManager.remove(entity);
    }

    public <I> IEntity<I> find(BiFunction<EntityManager, I, IEntity<I>> finder, I pk) {
        return finder.apply(entityManager, pk);
    }


    public void flush() {
        entityManager.flush();
        entityManager.clear();
    }

    public <I> IEntity<I> saveOrUpdate(Supplier<IEntity<I>> entity) {
        return entityManager.merge(entity.get());
    }


}
