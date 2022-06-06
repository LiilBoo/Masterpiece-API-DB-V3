package com.nandaparbat.SaasSportClubAPI.repositories;

import com.nandaparbat.SaasSportClubAPI.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {


    //* WORKS => DTO
    <Type> List<Type> findAllProjectedBy(Class<Type> type);

    Role findByRoleName(String roleName);

    boolean existsById(Long aLong);
}
