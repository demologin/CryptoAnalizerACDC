package com.javarush.alimova.commands;

public interface Command {
    Result startCommand(String[] parameters);
}
