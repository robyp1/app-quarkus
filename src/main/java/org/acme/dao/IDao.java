package org.acme.dao;

import org.acme.entities.IEntity;
import org.acme.entities.SexType;

import java.io.Serializable;

public interface IDao<T extends IEntity<?>> {

    <T> void save(T entity);

    <T> T update(T entity);

    <T> void delete(T entity);

    <T> T selectSingleResult(String sql, Class<T> theClass);

    void flush();

}
