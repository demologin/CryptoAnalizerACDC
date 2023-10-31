package com.javarush.berezovskiy.cryptoanalizer.command;

import com.javarush.berezovskiy.cryptoanalizer.entity.Result;

public interface Action {

    Result execute(String[] parameters);


}
