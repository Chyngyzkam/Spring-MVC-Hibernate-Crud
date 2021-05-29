package com.peaksoft.crud.dao;

import com.peaksoft.crud.model.Role;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;
import java.util.List;
@Repository
public class RoleDaoImpl implements RoleDao {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    @Transactional
    public List<String> getRoleNamesToList() {
        Session session = this.sessionFactory.getCurrentSession();
        return session.createQuery("select role from Role").getResultList();    }

    @Override
    @Transactional
    public Role getRoleByName(String name) {
        Session session = this.sessionFactory.getCurrentSession();
        Query query = session.createQuery("select role from Role role where role.role=:role");
        query.setParameter("role", name);
        return (Role) query.getSingleResult();
    }

    @Override
    @Transactional
    public List<Role> getAllRoles() {
        Session session = this.sessionFactory.getCurrentSession();
        return session.createQuery("from Role").list();
    }
}
