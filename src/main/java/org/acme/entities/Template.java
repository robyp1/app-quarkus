package org.acme.entities;

import javax.persistence.*;
import java.util.Objects;

/**
 * see ER diagram image for clarify entity class composition "tabelle templates diegaramma ER.PNG"
 *
 * column template_type contains discriminatorValue string TXT for TXT_TEMPLATE or HTML for HTML_TEMPLATE
 */
@Entity
@Table(name = "TEMPLATE")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "TEMPLATE_TYPE")
public abstract class Template implements IEntity<Long> {

    private Long id;

    private String name;

    private TemplateType templateType;

    private User user;

    @GeneratedValue(strategy = GenerationType.AUTO)
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
    @JoinColumn(name="USER_OWNER_ID") //this column have a foreign key
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
