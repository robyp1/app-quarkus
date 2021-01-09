package org.acme.entities;

import javax.persistence.*;
import java.util.Objects;

/**
 * see ER diagram image for clarify entity class composition "tabelle templates diegaramma ER.PNG"
 */
@Entity
@Table(name = "HTML_TEMPLATE")
@DiscriminatorValue("HTML")
public class HtmlTemplate extends Template implements IEntity<Long>{

    private String head;
    private String body;
    private Long id;

    public HtmlTemplate() {
    }

    public HtmlTemplate(String head, String body) {
        this.head = head;
        this.body = body;
    }

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

    @Column(name = "HEAD_CONTENT")
    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    @Column(name = "BODY_CONTENT")
    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        HtmlTemplate that = (HtmlTemplate) o;
        return Objects.equals(head, that.head) && Objects.equals(body, that.body) && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), head, body, id);
    }
}
