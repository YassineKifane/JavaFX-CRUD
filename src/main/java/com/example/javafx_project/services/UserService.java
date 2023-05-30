package com.example.javafx_project.services;

import com.example.javafx_project.dao.UserDao;
import com.example.javafx_project.dao.impl.DB;
import com.example.javafx_project.dao.impl.UserDaoImpl;
import com.example.javafx_project.entities.User;

public class UserService {

    private UserDao userDao = new UserDaoImpl();

    public void createUser(String username,String email, String password) {
        // Validate input if required
        User user = new User();
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(password);
        userDao.createUser(user);
    }

    public boolean authenticateUser(String username, String password) {
        User user = userDao.getUserByUsername(username);
        return user != null && user.getPassword().equals(password);
    }

    public User getUserByUsername(String username) {
        return userDao.getUserByUsername(username);
    }

}
