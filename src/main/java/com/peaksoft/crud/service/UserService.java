package com.peaksoft.crud.service;

import com.peaksoft.crud.model.User;

import java.util.List;

public interface UserService {

    User getByName(String name);

    void addUser(User user);

    List<User> getAllUsers();

    void updateUser(User user);


    void deleteUser(User user);

    User getById(Long id);

    User findByUsername(String s);
}

