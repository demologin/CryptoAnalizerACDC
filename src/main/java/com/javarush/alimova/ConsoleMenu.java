package com.javarush.alimova;

import java.util.Scanner;

import com.javarush.alimova.controller.MainController;

public class ConsoleMenu {
    public static void main(String[] args) {

        System.out.println("Пока разрабатываем только кодирование");
        Scanner console = new Scanner(System.in);
        String[] arg = {"nke", "mew"};
        MainController.giveCommand(console.nextLine(), arg);
    }
}
