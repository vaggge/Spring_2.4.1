package web.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.swing.text.html.parser.Entity;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> listOfUsers() {
        return (List<User>) entityManager.createQuery("FROM User").getResultList();
    }

    @Override
    public void addUser(User user){
        entityManager.persist(user);
    }

    @Override
    public void deleteUser(Long id) {
        entityManager.createQuery("DELETE FROM User WHERE id = ?1").setParameter(1, id).executeUpdate();
    }

    @Override
    public void editUser(Long id, User user){
        User oldUser = entityManager.find(User.class, id);
        oldUser.setUsername(user.getUsername());
        oldUser.setPassword(user.getPassword());
        entityManager.merge(oldUser);
    }

    @Override
    public User loadUserByUsername(String username) {
       return (User) entityManager.createQuery("FROM User WHERE username = ?1").setParameter(1, username).getSingleResult();
    }
}
