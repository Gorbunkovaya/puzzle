package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDao;
import web.model.User;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao ud;

    @Override
    public void createUser(User user) {
        ud.createUser(user);
    }

    @Override
    public void updateUser(User user) {
        ud.updateUser(user);
    }

    @Override
    public void deleteUser(Long id) {
        ud.deleteUser(id);
    }

    @Override
    public List<User> getUsersList() {
        return ud.getUsersList();
    }

    public User getUserById(Long id) {
        return ud.getUserById(id);
    }

    @Override
    public User getUserByName(String s) {
        return ud.getUserByName(s);
    }
}

