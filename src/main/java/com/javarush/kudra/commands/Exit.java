package com.javarush.kudra.commands;

import com.javarush.kudra.Execution;
import com.javarush.kudra.Result;
import com.javarush.kudra.constants.Constant;

public class Exit extends AbstractActions {

    @Override
    public Result execute(String[] parameters) {
        return new Result(Constant.EXIT);
    }
}
