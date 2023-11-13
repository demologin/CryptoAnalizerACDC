package com.javarush.stukalov;

import com.javarush.stukalov.controller.CesarCipherController;
import com.javarush.stukalov.view.CesarCipherMenu;
import com.javarush.stukalov.view.ConsoleApp;
import java.util.Scanner;

public class Launcher {
    public static void main(String[] args) {
        CesarCipherMenu menu = CesarCipherMenu.getInstance();
        CesarCipherController controller = CesarCipherController.getInstance();
        Scanner scanner = new Scanner(System.in);
        ConsoleApp app = new ConsoleApp(scanner,controller, menu);
        app.runApp();
    }
}
