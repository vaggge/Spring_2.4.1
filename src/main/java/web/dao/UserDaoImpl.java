package web.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import web.model.User;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<User> listOfUsers() {
        Session session = sessionFactory.openSession();
        return (List<User>) session.createQuery("FROM User ").getResultList();
    }

    @Override
    public void addUser(User user){
        Session session = sessionFactory.getCurrentSession();
        session.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("DELETE User u WHERE u.id = ?1");
        query.setParameter(1, id);
        query.executeUpdate();
    }

    @Override
    public void editUser(Long id, User user){
        Session session = sessionFactory.getCurrentSession();
        User oldUser = session.get(User.class, id);
        oldUser.setUsername(user.getUsername());
        oldUser.setPassword(user.getPassword());
        session.update(oldUser);
    }

    @Override
    public User loadUserByUsername(String username) {
        Session session = sessionFactory.getCurrentSession();
        Query<User> query = session.createQuery("FROM User WHERE username = ?1");
        query.setParameter(1, username);
        return query.uniqueResult();
    }
}
