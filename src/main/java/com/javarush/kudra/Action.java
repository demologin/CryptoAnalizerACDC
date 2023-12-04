package com.javarush.kudra;

import com.javarush.kudra.commands.Decode;
import com.javarush.kudra.commands.Encode;
import com.javarush.kudra.commands.Exit;
import com.javarush.kudra.constants.Constant;
import com.javarush.kudra.exceptions.AppException;

import java.util.Scanner;

public enum Action {
    ENCODE(1, new Encode()),
    DECODE(2, new Decode()),
    EXIT(3, new Exit());

    private final Execution execution;
    private final int numberOfOption;
    Action(int numberOfOption, Execution execution) {
        this.numberOfOption = numberOfOption;
        this.execution = execution;
    }

    public void execute(Scanner console) {
        this.execution.execute(console);
    }

    public static Action getByNumberOfOption(int numberOfOption){
        switch (numberOfOption){
            case 1: return ENCODE;
            case 2: return DECODE;
            case 3: return EXIT;
            default : throw new AppException(Constant.NON_EXISTENT_NUMBER);
        }
    }
}
