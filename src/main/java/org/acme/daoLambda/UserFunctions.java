package org.acme.daoLambda;

import org.acme.entities.*;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class UserFunctions {

    public IEntity<Long> getPrincipalUserDefaultTemplate() {
        String name = "Roby2";
        String surname = "P";
        SexType sexType = SexType.M;
        HtmlTemplate t = new HtmlTemplate();
        t.setTemplateType(TemplateType.IT);
        t.setName("DEFAULT_HTML");
        t.setHead("<HEAD></HEAD>");
        t.setBody("<BODY></BODY>");
        User u = new User();
        u.setName(name);
        u.setSurname(surname);
        u.setSexType(sexType);
        u.addTemplate(t);
        t.setUser(u);
        return u;
    }

    public User findUser(EntityManager entityManager, Long id){
        TypedQuery<User> query = entityManager.createQuery("from User u join fetch u.templates t where u.id= :userId", User.class).setParameter("userId", id);
        List<User> resultList = query.getResultList();
        if (resultList.size()>0)
            return resultList.get(0);
        else
            return null;
    }


}
