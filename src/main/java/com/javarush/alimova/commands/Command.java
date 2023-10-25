package com.javarush.alimova.commands;

public interface Command {

    void startCommand(String[] parameters);
    String resultCommand();
}
