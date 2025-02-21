package crud.dao;

import crud.entity.User;

import java.util.List;

public interface UserDao {
    List<User> getAllUsers();
    void addUser(User user);
    User getUserById(int id);
}
