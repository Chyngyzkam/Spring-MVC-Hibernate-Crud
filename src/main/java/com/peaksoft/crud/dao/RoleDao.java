package com.peaksoft.crud.dao;

import com.peaksoft.crud.model.Role;

import java.util.List;

public interface RoleDao {

    List<String> getRoleNamesToList();

    Role getRoleByName(String name);

    List<Role> getAllRoles();
}
