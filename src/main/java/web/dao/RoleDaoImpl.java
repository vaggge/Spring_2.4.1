package web.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import web.model.Role;

@Repository
public class RoleDaoImpl implements RoleDAO {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public Role getRoleByID(long id) {
        Session session = sessionFactory.openSession();
        Query<Role> query = session.createQuery("FROM Role r WHERE r.id = ?1");
        query.setParameter(1, id);
        Role role = query.uniqueResult();
        session.close();
        return role;
    }
}
