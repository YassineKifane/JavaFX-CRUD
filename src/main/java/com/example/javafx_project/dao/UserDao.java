package com.example.javafx_project.dao;

import com.example.javafx_project.entities.User;

public interface UserDao {
    void createUser(User user);
    User getUserByUsername(String username);
}
