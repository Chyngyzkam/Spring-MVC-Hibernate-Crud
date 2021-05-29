package com.peaksoft.crud.service;

import com.peaksoft.crud.dao.UserDao;
import com.peaksoft.crud.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

//    @Autowired
//    private PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public User getByName(String name) {
        return userDao.getByName(name);
    }

    @Override
    @Transactional
    public void addUser(User user) {
//        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userDao.addUser(user);
    }

    @Override
    @Transactional
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    @Transactional
    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    @Override
    @Transactional
    public void deleteUser(User user) {
        userDao.deleteUser(user);
    }

    @Override
    @Transactional
    public User getById(Long id) {
        return userDao.getById(id);
    }

    @Override
    public User findByUsername(String s) {
        return userDao.findByUsername(s);
    }
}
