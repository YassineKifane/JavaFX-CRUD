package com.example.javafx_project.dao.impl;

import com.example.javafx_project.dao.UserDao;
import com.example.javafx_project.entities.User;

import java.sql.*;

public class UserDaoImpl implements UserDao {

    private Connection conn= DB.getConnection();

    @Override
    public void createUser(User user) {
        PreparedStatement ps = null;

        try {
            ps = conn.prepareStatement("INSERT INTO users (username,email,password) VALUES (?,?,?)", Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getPassword());


            int rowsAffected = ps.executeUpdate();

            if (rowsAffected > 0) {
                ResultSet rs = ps.getGeneratedKeys();

                if (rs.next()) {
                    int id = rs.getInt(1);
                    user.setId(id);
                }
                DB.closeResultSet(rs);
            } else {
                System.out.println("Aucune ligne renvoyée");
            }
        } catch (SQLException e) {
            System.err.println("problème d'insertion d'un user");;
        } finally {
            DB.closeStatement(ps);
        }

    }

    @Override
    public User getUserByUsername(String username) {
        String query = "SELECT * FROM users WHERE username = ?";
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setString(1, username);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    // Retrieve the user data from the result set
                    int id = resultSet.getInt("id");
                    String password = resultSet.getString("password");

                    // Create a new User object
                    User user = new User();
                    user.setId(id);
                    user.setUsername(username);
                    user.setPassword(password);

                    return user;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null; // User not found
    }
}
