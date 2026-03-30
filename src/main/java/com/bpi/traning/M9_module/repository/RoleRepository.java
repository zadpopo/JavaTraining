package com.bpi.traning.M9_module.repository;

import com.bpi.traning.M9_module.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RoleRepository extends JpaRepository<Role, Long> {

    @Query("SELECT r.role FROM Role r WHERE r.user.id = :userId")
    List<String> findRolesByUserId(@Param("userId") Long userId);
}