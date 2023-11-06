package com.javarush.berezovskiy.cryptoAnalizer;
import com.javarush.berezovskiy.cryptoAnalizer.menu.Menu;
import java.util.Scanner;

public class Console {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        Menu menu = new Menu(console);
        menu.run();
    }
}
