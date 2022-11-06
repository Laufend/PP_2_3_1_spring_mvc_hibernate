package com.dmitriyfrolov.spring_mvc_hibernate.dao;

import com.dmitriyfrolov.spring_mvc_hibernate.entity.User;

import java.util.List;

public interface UserDAO {

    List<User> getAllUsers();

    void saveUser(User user);

    User show(int id);

    void updateUser(int id, User user);

    void deleteUser(int id);
}
