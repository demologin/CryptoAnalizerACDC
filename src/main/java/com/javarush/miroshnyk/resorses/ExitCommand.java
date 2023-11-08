package com.javarush.miroshnyk.resorses;

import com.javarush.miroshnyk.Runner;

public class ExitCommand {
    public static void execute() {
        ConsoleHelper.print("Exit");
        Runner.exit = true;
    }
}
