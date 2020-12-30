package org.acme.dao;

import org.acme.entities.*;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

@ApplicationScoped
public class UserDao extends DaoManager<User> {


    @Transactional
    public Long setPrincipalUserDefaultTemplate(String name, String surname, SexType sexType) {
        HtmlTemplate t = new HtmlTemplate();
        t.setTemplateType(TemplateType.IT);
        t.setName("DEFAULT_HTML");
        t.setHead("<HEAD></HEAD>");
        t.setBody("<BODY></BODY>");
        User u = new User(null, name, surname, sexType);
        u.addTemplate(t);
        t.setUser(u);
        save(u);
        flush();
        return u.getId();
    }

    public User find(Long id){
        //return find(id,User.class);
        TypedQuery<User> query = entityManager.createQuery("from User u join fetch u.templates t where u.id= :userId", User.class).setParameter("userId", id);
        return query.getResultList().get(0);
    }

}
