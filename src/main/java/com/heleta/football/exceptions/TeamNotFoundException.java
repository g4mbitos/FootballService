package com.heleta.football.exceptions;

public class TeamNotFoundException extends RuntimeException{
    public TeamNotFoundException(Long id) {
        super("Could not find team by id "+id);
    }

    public TeamNotFoundException(String name){
        super("Could not find team by name \""+name+"\"");
    }
}
