package com.nandaparbat.SaasSportClubAPI.entities;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "teams")
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "team_name")
    private String name;

    @ManyToMany
    @JoinTable(name = "teams_players",
            joinColumns = @JoinColumn(name = "team_id"),
            inverseJoinColumns = @JoinColumn(name = "player_id"))
    private List<Player> players;


    public Long getId() {
        return id;
    }
    // No setId!
    public String getName() {
        return name;
    };

    public void setName(String name) {
        this.name = name;
    };

    public List<Player> getPlayers() {
        return players;
    };

    public void setPlayers(List<Player> players) {
        this.players = players;
    };

    @Override
    public String toString() {
        return String.format("{id=%s, name=%s, members=%s}", id, name, players);
    }
}
