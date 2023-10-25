package com.javarush.khasanov.command;

import com.javarush.khasanov.entity.*;

public class Encrypt implements Action{
    @Override
    public Result execute(String[] parameters) {
        return new Result(ResultCode.OK, "Encrypt called");
    }
}
