package org.acme.resteasyjackson;

import org.acme.entities.TemplateType;

import javax.json.bind.annotation.JsonbProperty;

public class TemplateJson {

    private Long id;
    private String name;
    private TemplateType templateType;
    private String Content;
    private String UserId;

    public TemplateJson(Long id, String name, TemplateType templateType, String content, String userId) {
        this.id = id;
        this.name = name;
        this.templateType = templateType;
        Content = content;
        UserId = userId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    @JsonbProperty("template-name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TemplateType getTemplateType() {
        return templateType;
    }

    public void setTemplateType(TemplateType templateType) {
        this.templateType = templateType;
    }

    @JsonbProperty(nillable=true)
    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    @JsonbProperty(value = "ownerId",nillable = true)
    public String getUserId() {
        return UserId;
    }

    public void setUserId(String userId) {
        UserId = userId;
    }
}
