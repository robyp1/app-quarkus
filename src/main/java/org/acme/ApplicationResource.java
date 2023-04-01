package org.acme;

import org.acme.countryResponse.Country;
import org.acme.dao.IDao;
import org.acme.dao.MapperDto;
import org.acme.dao.UserDao;
import org.acme.daoLambda.DaoManagerLambda;
import org.acme.daoLambda.UserFunctions;
import org.acme.daoProducer.EntityTypeEnum;
import org.acme.daoProducer.IDaoManagerUser;
import org.acme.daoProducer.UserDaoProducer;
import org.acme.entities.HtmlTemplate;
import org.acme.entities.IEntity;
import org.acme.entities.SexType;
import org.acme.entities.User;
import org.acme.resteasyjackson.TemplateJson;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.logging.Logger;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.net.URI;

@Path("/hello-resteasy")
public class ApplicationResource {


    @Inject
    private UserDao userDao;

    @Inject
    private DaoManagerLambda daoManagerLambda;

    @Inject
    private UserFunctions userFunctions;

    @Inject
    @IDaoManagerUser(EntityTypeEnum.USER)
    private IDao userDaoProduced;


    @Inject
    private MapperDto mapperDto;

    @Inject
    @RestClient
    CountryRemoteResource countryRemoteResource;

//    @Inject
    private Logger logger = Logger.getLogger(ApplicationResource.class);

    @Context
    private UriInfo uriInfo;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public TemplateJson hello() {
        Long id = userDao.setPrincipalUserDefaultTemplate("Roby", "P", SexType.M);
        User user = userDao.find(id);
        HtmlTemplate template = (HtmlTemplate) user.getTemplates().get(0);
        return mapperDto.htmlTemplateToTemplateJson(user, template);
    }


    @GET
    @Path("/hello2")
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public TemplateJson hello2() {
        User entity = (User) daoManagerLambda.saveOrUpdate(userFunctions::getPrincipalUserDefaultTemplate);
        IEntity<Long> entity2 = daoManagerLambda.find(userFunctions::findUser, entity.getId());
        User user = (User) entity2;
        HtmlTemplate template = (HtmlTemplate) user.getTemplates().get(0);
        return mapperDto.htmlTemplateToTemplateJson(user, template);
    }


    @GET
    @Path("/hello3/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public TemplateJson hello3(@PathParam("name") final String name) {
        Long id = ((UserDaoProducer) userDaoProduced).setPrincipalUserDefaultTemplate(name, "P", SexType.M);
        User user = ((UserDaoProducer) userDaoProduced).find(id);
        HtmlTemplate template = (HtmlTemplate) user.getTemplates().get(0);
        return mapperDto.htmlTemplateToTemplateJson(user, template);
    }

    @GET
    @Path("/hello34")
    @Produces(MediaType.APPLICATION_JSON)
    public Response redirectAndResponse(){
        final String userName = "redirectUser" + System.currentTimeMillis();
        final URI redirectHello3 = uriInfo.getBaseUriBuilder().path(ApplicationResource.class).path(ApplicationResource.class, "hello3").build(userName);
        logger.info("Redirect user " + userName);
        return Response.status(Response.Status.SEE_OTHER).header(HttpHeaders.LOCATION,redirectHello3).build();
    }

    @GET
    @Path("/helloForRemote")
    @Produces({MediaType.APPLICATION_JSON})
    public Response CallRemoteRest(){
        Country[] countryInfo;
        try {
            countryInfo = countryRemoteResource.getCountryBy("italy");
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Failed "+ e.getMessage()).build();
        }
        return Response.status(Response.Status.OK).entity(countryInfo[0]).build();
    }
}