package crud.dao;

import crud.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {


    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<User> getAllUsers() {
        Session session = sessionFactory.getCurrentSession();
        List<User> users = session.createQuery("from User", User.class).getResultList();
        return users;
    }

    @Override
    public void addUser(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(user);
    }

    @Override
    public User getUserById(int id) {
        Session session = sessionFactory.getCurrentSession();
        User user = (User) session.get(User.class, id);
        return user;
    }

    @Override
    public void deleteUserById(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("delete from User where id=:id");
        query.setParameter("id", id);
        query.executeUpdate();
    }

    @Override
    public void createTable() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createNativeQuery("CREATE TABLE IF NOT EXISTS users (\n" +
                "                       id INT AUTO_INCREMENT PRIMARY KEY,\n" +
                "                       firstname VARCHAR(50) NOT NULL,\n" +
                "                       lastname VARCHAR(50) NOT NULL,\n" +
                "                       age INT CHECK (age >= 0)\n" +
                ");");
        query.executeUpdate();
    }
}
