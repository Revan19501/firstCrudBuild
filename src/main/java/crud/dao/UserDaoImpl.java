package crud.dao;

import crud.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {


    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getAllUsers() {

        List<User> users = entityManager.createQuery("from User", User.class).getResultList();
        return users;
    }

    @Override
    public void addUser(User user) {
        if (user.getId() == 0) {
            entityManager.persist(user);
        } else {
            entityManager.merge(user);
        }
    }

    @Override
    public User getUserById(int id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void deleteUserById(int id) {
        Query query = entityManager.createQuery("delete from User where id=:id");
        query.setParameter("id", id);
        query.executeUpdate();
    }

    @Override
    public void createTable() {

        Query query = entityManager.createNativeQuery("CREATE TABLE IF NOT EXISTS users (\n" +
                "                       id INT AUTO_INCREMENT PRIMARY KEY,\n" +
                "                       firstname VARCHAR(50) NOT NULL,\n" +
                "                       lastname VARCHAR(50) NOT NULL,\n" +
                "                       age INT CHECK (age >= 0)\n" +
                ");");
        query.executeUpdate();
    }
}
