package com.javarush.kotovych.containers;


import com.javarush.kotovych.commands.BruteForce;
import com.javarush.kotovych.commands.Decoder;
import com.javarush.kotovych.commands.Encoder;
import com.javarush.kotovych.commands.Nothing;
import com.javarush.kotovych.constants.Constants;

public enum ActionContainer {
    ENCODE(new Encoder()),
    DECODE(new Decoder()),
    BRUTE_FORCE(new BruteForce()),
    NOTHING(new Nothing()),
    ;

    private final Action action;

    ActionContainer(Action action){
        this.action = action;
    }

    public static Action get(String actionName){
        return switch (actionName){
            case Constants.ENCODE -> ENCODE.action;
            case Constants.DECODE ->DECODE.action;
            case Constants.BRUTE_FORCE -> BRUTE_FORCE.action;
            default -> NOTHING.action;
        };
    }
}
