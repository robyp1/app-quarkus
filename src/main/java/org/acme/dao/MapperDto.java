package org.acme.dao;

import org.acme.entities.HtmlTemplate;
import org.acme.entities.User;
import org.acme.resteasyjackson.TemplateJson;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.CDI)
public interface MapperDto {

    @Mapping(target = "id", source = "template.id")
    @Mapping(target = "name", source = "user.name")
    @Mapping(target = "content",  expression = "java(template.getHead() + template.getBody())")
    @Mapping(target = "userId", expression = "java(String.valueOf(user.getId()))")
    TemplateJson htmlTemplateToTemplateJson(User user, HtmlTemplate template);

   //IL CODICE GENERATO IN FASE DI COMPILAZIONE E' IN TARGET/GENERATED-SOURCES/ANNOTATIONS
}
