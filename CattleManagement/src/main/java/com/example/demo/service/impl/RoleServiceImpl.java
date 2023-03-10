package com.example.demo.service.impl;

import com.example.demo.model.Role;
import com.example.demo.repository.RoleRepo;
import com.example.demo.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepo roleRepo;

    @Override
    public List<Role> findAllRole() {
        return roleRepo.finAllRole();
    }

    @Override
    public void setRole(Long accountId, int roleId) {
        roleRepo.setRole(accountId, roleId);
    }

    @Override
    public Role findByRoleName(String name) {
        return roleRepo.findByRoleName(name);
    }
}
