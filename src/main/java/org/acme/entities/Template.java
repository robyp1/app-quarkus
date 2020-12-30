package org.acme.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "TEMPLATE")
public class Template implements IEntity<Long> {

    private Long id;

    private String name;

    private TemplateType templateType;

    private User user;

    @GeneratedValue
    @Id
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "NAME")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "TYPE")
    @Enumerated(EnumType.STRING)
    public TemplateType getTemplateType() {
        return templateType;
    }

    public void setTemplateType(TemplateType templateType) {
        this.templateType = templateType;
    }

    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name="USER_OWNER_ID")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Template template = (Template) o;
        return Objects.equals(id, template.id) && Objects.equals(name, template.name) && templateType == template.templateType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, templateType);
    }

    @Override
    public String toString() {
        return "Template{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", templateType=" + templateType +
                '}';
    }
}
