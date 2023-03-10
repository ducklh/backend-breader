package com.example.demo.repository;


import com.example.demo.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleRepo extends JpaRepository<Role, Long> {

    Role findByRoleName(String name);

    @Query(value = "select * from role",nativeQuery = true)
    List<Role> finAllRole();

    @Modifying
    @Query(value = "insert into account_role (account_id,role_id) values (?,?)", nativeQuery = true)
    void setRole(Long accountId, int roleId);
}
