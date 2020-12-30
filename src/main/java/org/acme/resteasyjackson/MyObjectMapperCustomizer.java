package org.acme.resteasyjackson;

import io.quarkus.jsonb.JsonbConfigCustomizer;

import javax.inject.Singleton;
import javax.json.bind.JsonbConfig;

//@Singleton
public class MyObjectMapperCustomizer
        //implements JsonbConfigCustomizer  //JSONB (jsonb default not admit null field!)
{
//    @Override
//    public void customize(JsonbConfig config) {
//        // To suppress serializing properties with null values
//        config.withPropertyNamingStrategy(JsonbConfig.NULL_VALUES);
//    }


//public class MyObjectMapperCustomizer implements ObjectMapperCustomizer { //JSONP with Jackson (default admit null field so exclude them here!)
//
//    @Override
//    public void customize(ObjectMapper objectMapper) {
//        // To suppress serializing properties with null values
//        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
//    }
}
