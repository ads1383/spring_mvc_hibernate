package web.dao;


import web.model.User;

import java.util.List;

public interface UserDao {
    void save(User user);
    List<User> listUsers();
    User getById(Long id);
    void delete(Long id);
}
