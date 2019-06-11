package com.heleta.football.exceptions;

public class PlayerNotFoundException extends RuntimeException {
    public PlayerNotFoundException(Long id) {
        super("Could not find player by id "+id);
    }

    public PlayerNotFoundException() {
        super("Could not find player");
    }
}
