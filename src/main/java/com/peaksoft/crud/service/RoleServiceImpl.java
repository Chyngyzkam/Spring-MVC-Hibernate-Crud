package com.peaksoft.crud.service;

import com.peaksoft.crud.dao.RoleDao;
import com.peaksoft.crud.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleDao roleDao;
@Autowired
    public RoleServiceImpl(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    @Transactional
    public List<String> getRoleNamesToList() {
        return roleDao.getRoleNamesToList();
    }

    @Override
    @Transactional
    public Role getRoleByName(String name) {
        return roleDao.getRoleByName(name);
    }

    @Override
    @Transactional
    public List<Role> getAllRoles() {
        return roleDao.getAllRoles();
    }
}
