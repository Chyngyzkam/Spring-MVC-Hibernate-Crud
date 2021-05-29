package com.peaksoft.crud.service;

import com.peaksoft.crud.model.Role;

import java.util.List;

public interface RoleService {

    List<String> getRoleNamesToList();

    Role getRoleByName(String name);

    List<Role> getAllRoles();
}
