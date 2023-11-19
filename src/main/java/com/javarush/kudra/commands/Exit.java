package com.javarush.kudra.commands;

import com.javarush.kudra.Execution;
import com.javarush.kudra.Result;
import com.javarush.kudra.constants.Constant;

import java.util.Scanner;

public class Exit extends AbstractActions {

    @Override
    public Result execute(Scanner console) {
        return new Result(Constant.EXIT);
    }
}
