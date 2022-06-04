package com.nandaparbat.SaasSportClubAPI.repositories;

import com.nandaparbat.SaasSportClubAPI.entities.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {

    Optional<Player> findByUsernameIgnoreCase(String username);

    //* WORKS => DTO
    <Type> List<Type> findAllProjectedBy(Class<Type> type);
};
