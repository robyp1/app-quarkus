package org.acme;

import org.acme.countryResponse.Country;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/v3.1")
@RegisterRestClient(configKey = "CountryService", baseUri="https://restcountries.com")
public interface CountryRemoteResource {

    @GET
    @Path("/name/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    Country[] getCountryBy(@PathParam("name") String countryName);
}
