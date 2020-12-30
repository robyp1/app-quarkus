package org.acme;

import org.acme.dao.DaoManager;
import org.acme.dao.IDao;
import org.acme.dao.UserDao;
import org.acme.entities.SexType;
import org.acme.entities.Template;
import org.acme.entities.TemplateType;
import org.acme.entities.User;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/hello-resteasy")
public class ApplicationResource {


    @Inject
    private UserDao userDao;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        userDao.setPrincipalUserDefaultTemplate("Roby","P", SexType.M);
        return "OK";
        //return "Hello RESTEasy with Quarkus!";
    }
}