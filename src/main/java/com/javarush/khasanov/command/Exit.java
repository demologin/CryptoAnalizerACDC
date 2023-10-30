package com.javarush.khasanov.command;

import com.javarush.khasanov.entity.*;

import static com.javarush.khasanov.view.Messages.APPLICATION_CLOSED;

public class Exit implements Action{
    @Override
    public Result execute(String[] parameters) {
        return new Result(ResultCode.OK, APPLICATION_CLOSED);
    }
}
