package com.javarush.khasanov.command;

import com.javarush.khasanov.entity.Result;

public interface Action {
    Result execute(String[] parameters);
}
