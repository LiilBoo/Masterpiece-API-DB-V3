package com.nandaparbat.SaasSportClubAPI.services;

import com.nandaparbat.SaasSportClubAPI.DTOs.roles.RoleIDTO;
import com.nandaparbat.SaasSportClubAPI.DTOs.roles.RoleTransactionDTO;
import com.nandaparbat.SaasSportClubAPI.entities.Role;
import com.nandaparbat.SaasSportClubAPI.repositories.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    //* --- CREATE REQUEST
    @Override
    public void createRole(RoleTransactionDTO inputs) {
        Role createdRole = new Role();
        createdRole.setRoleName(inputs.getName());
        roleRepository.save(createdRole);
    };

    //* READ REQUEST
    //*WORKS
    @Override
    public List<RoleIDTO> listOfRoles() {
        return roleRepository.findAllProjectedBy(RoleIDTO.class);
    }


    //*
    @Override
    public void updateRole(RoleTransactionDTO inputs, Long id) {
        Role role = roleRepository.getById(id);
        role.setRoleName(inputs.getName());

        roleRepository.save(role);
    };

    //* WORKS
    @Override
    public void deleteRole(Long id) {
            roleRepository.delete(roleRepository.getById(id));
    };
};
