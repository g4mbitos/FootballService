package com.heleta.football.repos;

import com.heleta.football.enteties.Player;
import com.heleta.football.enteties.Position;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface PlayerRepo extends JpaRepository<Player, Long> {

        List<Player> findByFirstName(String firstName);

        List<Player> findByLastName(String lastName);

        List<Player> findByFirstNameAndLastName(String firstName, String lastName);

        Optional<Player> findByFirstNameAndLastNameAndBirthday(String firstName, String lastName, Date birth);

        Optional<Player> findByFirstNameAndLastNameAndBirthdayAndPosition(String firstName, String lastName, Date birth, Position position);

        List<Player> findByBirthday(Date birth);

        List<Player> findByPosition(Position position);

        List<Player> findByTeam_Name(String name);
}
