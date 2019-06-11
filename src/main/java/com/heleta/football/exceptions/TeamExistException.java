package com.heleta.football.exceptions;

public class TeamExistException extends RuntimeException {
    public TeamExistException(Long id) {
        super("Team with id "+id+ " already exist.");
    }
    public TeamExistException(String name) {
        super("Team with name "+name+ " already exist.");
    }

}
