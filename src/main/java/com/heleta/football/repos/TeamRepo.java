package com.heleta.football.repos;

import com.heleta.football.enteties.Team;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TeamRepo extends JpaRepository<Team, Long> {

    Optional<Team> findByName(String name);

    Team findByCaptain_Id(Long id);
}
