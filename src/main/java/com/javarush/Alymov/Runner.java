package com.javarush.Alymov;

import com.javarush.Alymov.Menu.MenuApp;
import com.javarush.Alymov.Menu.MenuMessages;
import com.javarush.Alymov.Menu.MenuView;
import com.javarush.khmelov.view.console.Menu;

import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        System.out.println(MenuMessages.HELLO);
        Scanner inputStream = new Scanner(System.in);
        MenuView menuView = new MenuView(inputStream);

    }
}
