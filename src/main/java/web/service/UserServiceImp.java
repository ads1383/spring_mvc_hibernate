package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDao;
import web.model.User;

import java.util.ArrayList;
import java.util.List;

@Transactional
@Service
public class UserServiceImp implements UserService{

    private UserDao userDao;

    public UserServiceImp() {
    }

    @Autowired
    public UserServiceImp(UserDao userDao) {
        super();
        this.userDao = userDao;
    }

    @Override
    public void save(User user) {
        userDao.save(user);
    }

    @Override
    public List<User> listUsers() {
        List list = new ArrayList();
        userDao.findAll().forEach(e -> list.add(e));
        return list;
    }

    @Override
    public User getById(Long id) {
        return userDao.findById(id).get();
    }

    @Override
    public void delete(Long id) {
        userDao.deleteById(id);
    }

}
