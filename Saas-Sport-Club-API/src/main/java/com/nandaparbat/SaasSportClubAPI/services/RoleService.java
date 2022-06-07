package com.nandaparbat.SaasSportClubAPI.services;

import com.nandaparbat.SaasSportClubAPI.DTOs.RoleIDTO;
import com.nandaparbat.SaasSportClubAPI.DTOs.roles.RoleTransactionDTO;

import java.util.List;

public interface RoleService {

   //*CREATE REQUEST
   void createRole(RoleTransactionDTO inputs);

   //*READ REQUEST
   List<RoleIDTO> listOfRoles();

   //*UPDATE REQUEST
   void updateRole(RoleTransactionDTO inputs, Long id);

   //*DELETE REQUEST
   void deleteRole(Long id);

};
