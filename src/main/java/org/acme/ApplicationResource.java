package org.acme;

import org.acme.dao.DaoManager;
import org.acme.dao.IDao;
import org.acme.dao.UserDao;
import org.acme.entities.*;
import org.acme.resteasyjackson.TemplateJson;

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
    @Produces(MediaType.APPLICATION_JSON)
    public TemplateJson hello() {
        Long id = userDao.setPrincipalUserDefaultTemplate("Roby", "P", SexType.M);
        User user = userDao.find(id);
        HtmlTemplate template = (HtmlTemplate) user.getTemplates().get(0);
        return new TemplateJson(template.getId(),user.getName(), template.getTemplateType(),template.getHead() + template.getBody(), String.valueOf(user.getId()));
        //return "Hello RESTEasy with Quarkus!";
    }
}