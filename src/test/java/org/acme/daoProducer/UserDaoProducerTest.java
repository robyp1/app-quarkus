package org.acme.daoProducer;

import org.acme.dao.IDao;
import org.acme.entities.SexType;
import org.acme.entities.User;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class UserDaoProducerTest implements IDao<User> {

    public Long setPrincipalUserDefaultTemplate(String name, String surname, SexType sexType) {
        return 1L;
    }

    public User find(Long id){
        return new User(1L, "testuser","testuser", SexType.M);
    }


    @Override
    public <T> void save(T entity) {

    }

    @Override
    public <T> T update(T entity) {
        return null;
    }

    @Override
    public <T> void delete(T entity) {

    }

    @Override
    public <T> T find(Long id, Class<T> theClass) {
        return null;
    }

    @Override
    public void flush() {

    }
}
