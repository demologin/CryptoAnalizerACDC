package com.javarush.Alymov.comands;

import com.javarush.Alymov.entity.Result;

public interface Action {
    Result execute(String[] parametrs);
}
