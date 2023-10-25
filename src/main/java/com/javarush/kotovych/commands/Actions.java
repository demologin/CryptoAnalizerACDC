package com.javarush.kotovych.commands;


public enum Actions {
    ENCODE(new Encoder()),
    DECODE(new Decoder()),
    BRUTE_FORCE(new BruteForce()),
    EXIT(new Exit());
    ;

    private final Action action;

    Actions(Action action){
        this.action = action;
    }

    public static Action get(String actionName){
        Action returnAction;
        returnAction = switch (actionName){
            case "ENCODE" -> ENCODE.action;
            case "DECODE" ->DECODE.action;
            case "BRUTE_FORCE" -> BRUTE_FORCE.action;
            default -> EXIT.action;
        };

        return returnAction;
    }
}
