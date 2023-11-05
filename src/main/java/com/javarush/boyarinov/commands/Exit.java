package com.javarush.boyarinov.commands;

public class Exit {

    private Exit(){}

    public static Exit getInstance(){
        return new Exit();
    }

    public void stopApp() {
        System.out.println("Программа завершена!");
    }
}
