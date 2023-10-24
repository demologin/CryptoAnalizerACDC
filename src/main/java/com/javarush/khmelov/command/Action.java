package com.javarush.khmelov.command;

import com.javarush.khmelov.entity.Result;

public interface Action {

    Result execute(String[] parameters);


}
