package org.acme.entities;

import javax.persistence.*;
import java.util.Objects;

/**
 * see ER diagram image for clarify entity class composition "tabelle templates diegaramma ER.PNG"
 */
@Entity
@Table(name = "TXT_TEMPLATE")
@DiscriminatorValue("TXT")
public class TxtTemplate extends Template implements IEntity<Long>{

    private String content;
    private Long id;

    @Override
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "TXT_CONTENT")
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        TxtTemplate that = (TxtTemplate) o;
        return Objects.equals(content, that.content) && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), content, id);
    }
}
