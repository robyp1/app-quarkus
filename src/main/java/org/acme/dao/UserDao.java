package org.acme.dao;

import org.acme.entities.SexType;
import org.acme.entities.Template;
import org.acme.entities.TemplateType;
import org.acme.entities.User;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

@ApplicationScoped
@Transactional
public class UserDao extends DaoManager<User> {


    public void setPrincipalUserDefaultTemplate(String name, String surname, SexType sexType) {
        Template t = new Template();
        t.setTemplateType(TemplateType.IT);
        t.setName("DEFAULT");
        User u = new User(null, name, surname, sexType);
        u.addTemplate(t);
        t.setUser(u);
        save(u);
        flush();
    }

}
