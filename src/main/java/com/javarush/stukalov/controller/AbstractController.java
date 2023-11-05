package com.javarush.stukalov.controller;

import java.util.List;

public abstract class AbstractController {

    public abstract void run(int command, List<String> params);
}
