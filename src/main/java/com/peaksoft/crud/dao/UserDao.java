package com.peaksoft.crud.dao;

import com.peaksoft.crud.model.User;

import java.util.List;

public interface UserDao {

    User getByName(String name);

    void addUser(User user);

    List<User> getAllUsers();

    void updateUser(User user);

    void deleteUser(User user);

    User getById(Long id);

    User findByUsername(String s);
}


