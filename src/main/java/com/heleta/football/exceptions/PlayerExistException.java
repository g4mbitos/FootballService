package com.heleta.football.exceptions;

public class PlayerExistException extends RuntimeException {
    public PlayerExistException(Long id) {
        super("Player with id "+id+ " already exist.");
    }

    public PlayerExistException() {
        super("Player already exist.");
    }
}
