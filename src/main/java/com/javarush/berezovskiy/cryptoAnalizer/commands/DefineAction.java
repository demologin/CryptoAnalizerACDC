package com.javarush.berezovskiy.cryptoAnalizer.commands;

import com.javarush.berezovskiy.cryptoAnalizer.menu.MenuValues;

public class DefineAction {
    FileAction fileAction;
    private static MenuValues parameters;

    public void doAction(MenuValues parameters){
        DefineAction.parameters = parameters;
        fileAction = FileActionEnum.get();
        fileAction.runFile();
    }
    public static MenuValues getParameters(){
        return parameters;
    }

}
