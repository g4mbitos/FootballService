package com.heleta.football.enteties;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "teams")
public class Team  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "cap_id")
    private Player captain;

    @OneToMany(mappedBy = "team")
    private List<Player> players;

    public Team() {
    }

    public Team(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public Team setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Team setName(String name) {
        this.name = name;
        return this;
    }

    public Player getCaptain() {
        return captain;
    }

    public Team setCaptain(Player captain) {
        this.captain = captain;
        return this;
    }

    public List<Player> getPlayers() {
        return players;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {

        if(!(obj instanceof Team))
            return false;

        Team team = (Team)obj;

        return name.equals(team.name);
    }

    @Override
    public String toString() {
        return name + (captain != null ? " "+captain.getFirstName()+" "+captain.getLastName() : "");
    }
}


