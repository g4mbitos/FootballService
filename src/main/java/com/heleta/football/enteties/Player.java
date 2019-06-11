package com.heleta.football.enteties;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "players")
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    private Date birthday;

    private Position position;

    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team;

    public Player() {
    }

    public Player(String firstName, String lastName, Date birthday, Position position) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.position = position;
    }

    public Player(String firstName, String lastName, Date birthday, Position position, Team team) {
        this(firstName, lastName, birthday, position);
        this.team = team;
    }



    public Long getId() {
        return id;
    }

    public Player setId(Long id) {
        this.id = id;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public Player setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public Player setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public Date getBirthday() {
        return birthday;
    }

    public Player setBirthday(Date birthday) {
        this.birthday = birthday;
        return this;
    }

    public Position getPosition() {
        return position;
    }

    public Player setPosition(Position position) {
        this.position = position;
        return this;
    }

    @JsonIgnore
    public Team getTeam() {
        return team;
    }

    public Player setTeam(Team team) {
        this.team = team;
        return this;
    }

    @Override
    public String toString() {
        return firstName+" "+lastName+", role: "+position;
    }
}

