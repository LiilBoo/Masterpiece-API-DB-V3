package com.nandaparbat.SaasSportClubAPI.services;

import com.nandaparbat.SaasSportClubAPI.DTOs.*;
import com.nandaparbat.SaasSportClubAPI.entities.Player;
import com.nandaparbat.SaasSportClubAPI.entities.Role;
import com.nandaparbat.SaasSportClubAPI.repositories.PlayerRepository;
import com.nandaparbat.SaasSportClubAPI.repositories.RoleRepository;
import com.nandaparbat.SaasSportClubAPI.security.Jwt;
import com.nandaparbat.SaasSportClubAPI.security.JwtProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PlayerServiceImpl implements PlayerService {

    private final RoleRepository roleRepository;

    private final PlayerRepository playerRepository;

    private final PasswordEncoder encoder;

    private final JwtProvider provider;



    @Override
    public List<MyToursDTO> myToursByMyId(Long id) {
        return null;
    };

    @Override
    public PlayerDTO myInfosByMyId(Long id) {
        return null;
    };

    @Override
    public void updateMyInfos(Long id) {

    };

    @Override
    public void updateMyTours(Long id) {

    }

//    @Override
//    @Transactional
//    public void playerRoleSetting(@RequestParam("id") Long playerId, @RequestBody RoleSettingDTO roleBody) {
//        Player player = playerRepository.getById(playerId);
//        Role role = roleRepository.getById(roleBody.getRoleId());
//
//                      Long number = 1L;
//
//        if(!roleBody.getRoleId().equals(number) &&
//                (roleRepository.existsById(role.getId()))){
//            player.setRole(role);
//        };
//    };

    @Override
    public void unregisterFromTournament(Long tourID, Long myPersonalId) {

    };

    @Override
    public void deleteMyProfile(Long id) {

    };

    @Override
    public void deleteMeFromTeam(Long teamId, Long myId) {

    };




    //TODO : ADD Business logic : fide elo, fide number, firstname, lastname,

    //! AUTH
    //! DONT MODIFY
    //!-------------------
    @Transactional
    @Override
    public void create(PlayerCreate inputs){
        Player player = new Player();
        player.setUsername(inputs.getUsername());

        String encoded = encoder.encode(inputs.getPassword());
        player.setPassword(encoded);

        //*-------------------
        player.setFirstName(inputs.getFirstName());
        player.setLastName(inputs.getLastName());
        player.setElo(inputs.getElo());
        player.setFideNumber(inputs.getFideNumber());
        //*-------------------



        playerRepository.save(player);
    };
    @Override
    public Jwt signIn(PlayerSignIn inputs) {

        String username = inputs.getUsername();
        Player player =
                playerRepository.findByUsernameIgnoreCase(username).orElseThrow(
                    () -> new BadCredentialsException(String.format("password does not match for username '%s' ", username)
                        )
                );

        String password = inputs.getPassword();

        if(!encoder.matches(password, player.getPassword() )){
            throw new BadCredentialsException(String.format("password does " +
                    "not match username '%s' ", username));
        };

        Role role = player.getRole();

        List<String> roles = null;

        if(role != null){
            roles = List.of(role.getRoleName());
        };

        return provider.create(String.valueOf(player.getId()), roles);
    }
    //!---------- AUTH ------------
    //! DONT CHANGE

};
