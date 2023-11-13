package com.javarush.alimova;

import com.javarush.alimova.controller.MainController;
import com.javarush.alimova.view.picocli.Picocli;
import picocli.CommandLine;

public class PicocliStarting {

    public static void main(String[] args) {
        MainController mainController = new MainController();

        Picocli command = new Picocli(mainController);
        CommandLine commandLine = new CommandLine(command);
        int exitCode = commandLine.execute(args);

        System.exit(exitCode);
    }
}
