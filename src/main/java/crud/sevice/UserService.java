package crud.sevice;

import crud.entity.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    void addUser(User user);
    User getUserById(int id);
}
