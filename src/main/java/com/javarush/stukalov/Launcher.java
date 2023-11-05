package com.javarush.stukalov;

import com.javarush.stukalov.view.ConsoleApp;
import java.util.Scanner;

public class Launcher {
    public static void main(String[] args) {
        ConsoleApp app = new ConsoleApp(new Scanner(System.in));
        app.runApp();
    }
}
