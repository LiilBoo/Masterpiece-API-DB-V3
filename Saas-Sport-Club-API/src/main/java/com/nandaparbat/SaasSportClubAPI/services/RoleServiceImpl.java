package com.nandaparbat.SaasSportClubAPI.services;

import com.nandaparbat.SaasSportClubAPI.DTOs.RoleIDTO;
import com.nandaparbat.SaasSportClubAPI.repositories.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    @Override
    public List<RoleIDTO> listOfRoles() {
        return roleRepository.findAllProjectedBy(RoleIDTO.class);
    };
};
