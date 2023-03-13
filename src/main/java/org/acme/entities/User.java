package org.acme.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * see ER diagram image for clarify entity class composition "tabelle templates diegaramma ER.PNG"
 */
@Entity
@Table(name = "USERS")
public class User implements IEntity<Long>{

    private Long id;
    private String name;
    private String surname;
    private SexType sexType;
    private List<Template> templates = new ArrayList<>();

    public User() {
    }

    public User(Long id, String name, String surname, SexType sexType) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.sexType = sexType;
    }

    public User(Long id, String name, String surname, SexType sexType, List<Template> templates) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.sexType = sexType;
        this.templates = templates;
    }

    public User(Long id) {
        this.id=id;
    }

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

    @Column(name = "SURNAME")
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Column(name = "SEX")
    @Enumerated(EnumType.STRING)
    public SexType getSexType() {
        return sexType;
    }

    public void setSexType(SexType sexType) {
        this.sexType = sexType;
    }

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    public List<Template> getTemplates() {
        return templates;
    }

    public void setTemplates(List<Template> templates) {
        this.templates = templates;
    }

    /*add a template to list*/
    public void addTemplate(Template template){
        template.setUser(this);
        this.templates.add(template);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) && Objects.equals(name, user.name) && Objects.equals(surname, user.surname) && sexType == user.sexType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, sexType);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", sexType=" + sexType +
                '}';
    }
}
