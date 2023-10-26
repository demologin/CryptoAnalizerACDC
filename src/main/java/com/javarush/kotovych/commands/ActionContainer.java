package com.javarush.kotovych.commands;


public enum ActionContainer {
    ENCODE(new Encoder()),
    DECODE(new Decoder()),
    BRUTE_FORCE(new BruteForce()),
    NOTHING(new Nothing());
    ;

    private final Action action;

    ActionContainer(Action action){
        this.action = action;
    }

    public static Action get(String actionName){
        Action returnAction;
        returnAction = switch (actionName){
            case "ENCODE" -> ENCODE.action;
            case "DECODE" ->DECODE.action;
            case "BRUTE_FORCE" -> BRUTE_FORCE.action;
            default -> NOTHING.action;
        };

        return returnAction;
    }
}
