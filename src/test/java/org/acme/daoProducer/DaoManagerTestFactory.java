package org.acme.daoProducer;

import org.acme.dao.IDao;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.ws.rs.Produces;

@Dependent

public class DaoManagerTestFactory {

    @Inject
    UserDaoProducerTest userDaoProducerTest;

    @Produces
    @IDaoManagerUser(EntityTypeEnum.USER)
    public IDao getUserManager() {
        return userDaoProducerTest;
    }
}
