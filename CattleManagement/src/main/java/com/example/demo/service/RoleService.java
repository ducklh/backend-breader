package com.example.demo.service;

import com.example.demo.model.Role;

import java.util.List;

public interface RoleService {
    List<Role> findAllRole();

    void setRole(Long accountId, int roleId);

    Role findByRoleName(String name);
}
