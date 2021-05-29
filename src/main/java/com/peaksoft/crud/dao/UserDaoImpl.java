package com.peaksoft.crud.dao;

import com.peaksoft.crud.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class UserDaoImpl implements UserDao {

    public UserDaoImpl() {
    }

    @Autowired
    private SessionFactory sessionFactory;

    public UserDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public User getByName(String name) {
        return sessionFactory.getCurrentSession().get(User.class, name);
    }


    @Override
    public void addUser(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return sessionFactory.getCurrentSession().createQuery("from User").list();
    }

    @Override
    public void updateUser(User user) {
        sessionFactory.getCurrentSession().merge(user);
    }

    @Override
    public void deleteUser(User user) {
        sessionFactory.getCurrentSession().delete(user);

    }

    @Override
    public User getById(Long id) {
        return sessionFactory.getCurrentSession().get(User.class, id);
    }

    @Override
    public User findByUsername(String s) {
        List<User>users = getAllUsers();
        return users.stream().filter(x -> x.getName().equals(s)).findAny().orElse(null);
    }
}
