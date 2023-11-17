package com.javarush.kudra;

import com.javarush.kudra.commands.Decode;
import com.javarush.kudra.commands.Encode;
import com.javarush.kudra.commands.Exit;

public enum Action {
    ENCODE(new Encode()),
    DECODE(new Decode()),
    EXIT(new Exit());


    Action(Execution execution) {
        this.execution = execution;
    }
    public final Execution execution;

}
