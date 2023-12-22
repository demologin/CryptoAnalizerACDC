package com.javarush.Alymov;

import com.javarush.Alymov.Menu.MenuApp;
import com.javarush.Alymov.Menu.MenuMessages;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        System.out.println(MenuMessages.HELLO);
        Scanner inputStream = new Scanner(System.in);
        MenuApp.showMenu(inputStream);
    }
}
