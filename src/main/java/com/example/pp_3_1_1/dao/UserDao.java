package com.example.pp_3_1_1.dao;


import com.example.pp_3_1_1.model.User;

import java.util.List;

public interface UserDao {
    void addUser(User user);

    User getUserById(int id);

    User updateUser(User user);

    void removeUserById(int id);

    List<User> getAllUsers();
}
