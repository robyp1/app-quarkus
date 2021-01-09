package org.acme.daoProducer;

import org.acme.dao.IDao;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.Produces;
import java.io.Serializable;

/**
 * define a factory class, wich one method define amn implementation to inject via annotation @inject for Idao type declaration
 */
@ApplicationScoped
public class DaoManagerFactory implements Serializable {

    @Inject
    private UserDaoProducer userDaoProducer;

    /**
     *
     * example inject an implementation of Idao type declaration (general interface declaration type) of type UserDaoProducer
     * in a other class, use annotation @IDaoManagerUser and enum EntityTypeEnum combined like:
     * @Inject
     * @IDaoManagerUser(EntityTypeEnum.USER)
     * private IDao userDao;
     */
    @Produces
    @IDaoManagerUser(EntityTypeEnum.USER)
    public IDao getUserManager() {
        return userDaoProducer;
    }
}
