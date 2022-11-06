package com.dmitriyfrolov.spring_mvc_hibernate.service;

import com.dmitriyfrolov.spring_mvc_hibernate.dao.UserDAO;
import com.dmitriyfrolov.spring_mvc_hibernate.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    public final UserDAO userDAO;

    @Autowired
    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Transactional
    @Override
    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }

    @Transactional
    @Override
    public void saveUser(User user) {
        userDAO.saveUser(user);
    }

    @Transactional
    @Override
    public User show(int id) {
        return userDAO.show(id);
    }

    @Transactional
    @Override
    public void updateUser(int id, User user) {
        userDAO.updateUser(id, user);
    }

    @Transactional
    @Override
    public void deleteUser(int id) {
        userDAO.deleteUser(id);
    }


}
