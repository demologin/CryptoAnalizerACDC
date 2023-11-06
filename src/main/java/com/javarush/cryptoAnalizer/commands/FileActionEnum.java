package com.javarush.cryptoAnalizer.commands;

import com.javarush.cryptoAnalizer.exceptions.ConsoleException;
import com.javarush.cryptoAnalizer.menu.MenuValues;
import com.javarush.cryptoAnalizer.messages.Message;

public enum FileActionEnum {
    ENCRYPTED(new Encrypt()),
    DECRYPTED(new Decrypt()),
    BRUTEFORCE(new BruteForce());

    private final FileAction fileAction;
    private static int actionIndex;
    private static String actionName;
    private static FileActionEnum[] enums = FileActionEnum.values();
    private static MenuValues parameters;

    FileActionEnum(FileAction fileAction) {
        this.fileAction = fileAction;
    }

    public static FileAction get() {
        parameters = DefineAction.getParameters();
        actionName = parameters.getFileAction();
        actionIndex = Integer.parseInt(actionName);
        try {
            FileActionEnum value = enums[actionIndex];
            return value.fileAction;
        } catch (IllegalArgumentException e) {
            throw new ConsoleException(Message.INCORRECT_ACTION);
        }
    }

    public static int getActionsArrayLength(){
        return enums.length;
    }
}
